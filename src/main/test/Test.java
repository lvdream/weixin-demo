import org.apache.commons.lang3.StringUtils;

public class Test {
    String string = "ALTER TABLE mstb_store_product_instore_material_detail\n" +
            "  ADD psam_option5 VARCHAR(100) NULL\n" +
            "COMMENT '生产加工图名称';\n" +
            "ALTER TABLE mstb_store_product_instore_material_detail\n" +
            "  ADD psa_code VARCHAR(100) NULL\n" +
            "COMMENT '设计单号';\n" +
            "ALTER TABLE mstb_store_product_instore_material_detail\n" +
            "  ADD psa_type VARCHAR(2) NULL\n" +
            "COMMENT '设计单类型';\n" +
            "\n" +
            "ALTER TABLE mstb_store_product_outstore\n" +
            "  ADD spo_type VARCHAR(1) DEFAULT NULL\n" +
            "COMMENT '出库类型：0组件板块出库 1组件缺件材料出库  2清单材料出库';\n" +
            "ALTER TABLE mstb_store_product_outstore\n" +
            "  ADD spi_id BIGINT(1) NULL\n" +
            "COMMENT '成品入库单ID';\n" +
            "ALTER TABLE mstb_store_product_outstore_detail\n" +
            "  ADD process_number VARCHAR(100) DEFAULT NULL\n" +
            "COMMENT '组件工艺号';\n" +
            "ALTER TABLE mstb_store_product_outstore_detail\n" +
            "  ADD mpdz_id INT(11) DEFAULT NULL\n" +
            "COMMENT '组装计划明细id';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD psam_option1 VARCHAR(100) NULL\n" +
            "COMMENT '预留字段1 For 工艺图（JSON格式）';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD psam_option2 VARCHAR(255) NULL\n" +
            "COMMENT '预留字段2 For 生产加工图（JSON格式）';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD psam_ompName VARCHAR(100) NULL\n" +
            "COMMENT '工艺图名称';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD psam_option5 VARCHAR(100) NULL\n" +
            "COMMENT '生产加工图名称';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD mpdq_id INT(11) NULL\n" +
            "COMMENT '加工材料清单ID';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD psa_code VARCHAR(100) NULL\n" +
            "COMMENT '设计单号';\n" +
            "ALTER TABLE mstb_store_product_outstore_material_detail\n" +
            "  ADD psa_type VARCHAR(2) NULL\n" +
            "COMMENT '设计单类型';\n" +
            "ALTER TABLE mstb_store_product_material_receive_summary_log\n" +
            "  MODIFY pmrsl_option1 VARCHAR(100) DEFAULT NULL\n" +
            "  COMMENT 'For 操作单号';\n" +
            "ALTER TABLE mstb_store_product_receive_summary_log\n" +
            "  MODIFY prsl_option1 VARCHAR(100) DEFAULT NULL\n" +
            "  COMMENT 'For 操作单号';";
    String s2 ="\n" +
            "SET @s = (SELECT IF(\n" +
            "    (SELECT COUNT(*)\n" +
            "        FROM INFORMATION_SCHEMA.COLUMNS\n" +
            "        WHERE table_name = 'table_$$'\n" +
            "        AND table_schema = DATABASE()\n" +
            "        AND column_name = 'column_$$'\n" +
            "    ) > 0,\n" +
            "    \"SELECT 1\",\n" +
            "    \"ALT_$$ \"));\n" +
            "\n" +
            "PREPARE stmt FROM @s;\n" +
            "EXECUTE stmt;\n" +
            "DEALLOCATE PREPARE stmt;";
    @org.junit.Test
    public void tet(){
        String[] strings = StringUtils.splitByWholeSeparator(string,"ALTER");
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String table = StringUtils.substringAfter(s,"TABLE");
            table = StringUtils.substringBefore(table,"\n");
            table = StringUtils.replace(table,"\n","");
            table = StringUtils.replace(table," ","");
            String column = StringUtils.substringAfter(s,"ADD ");
            column = StringUtils.substringBefore(column," ");
            String sql = StringUtils.replace(s2,"table_$$",table);
            sql = StringUtils.replace(sql,"column_$$",column);
            sql = StringUtils.replace(sql,"ALT_$$","ALTER "+s);
//            sql = StringUtils.replace(sql,";","");
            System.out.println(sql);
            System.out.println();

        }
    }
}

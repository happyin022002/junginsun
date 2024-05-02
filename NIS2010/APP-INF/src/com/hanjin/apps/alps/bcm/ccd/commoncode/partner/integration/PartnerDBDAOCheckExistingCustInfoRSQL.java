/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOCheckExistingCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOCheckExistingCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PartnerDBDAOCheckExistingCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOCheckExistingCustInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DISTINCT A.CNT AS CUST_SEQ " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT 'SC' CNT" ).append("\n"); 
		query.append("      FROM PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("     WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'RFA' CNT" ).append("\n"); 
		query.append("      FROM PRI_RP_MN" ).append("\n"); 
		query.append("     WHERE CTRT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND CTRT_CUST_CNT_CD = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'SC' CNT" ).append("\n"); 
		query.append("      FROM PRI_SP_AFIL" ).append("\n"); 
		query.append("     WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'RFA' CNT" ).append("\n"); 
		query.append("      FROM PRI_RP_AFIL" ).append("\n"); 
		query.append("     WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Invoice'" ).append("\n"); 
		query.append("      FROM INV_AR_MN" ).append("\n"); 
		query.append("     WHERE ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'AR'" ).append("\n"); 
		query.append("      FROM SAR_OTS_HDR" ).append("\n"); 
		query.append("     WHERE BIL_TO_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND BIL_TO_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'AR'" ).append("\n"); 
		query.append("      FROM SAR_OTS_HIS" ).append("\n"); 
		query.append("     WHERE BIL_TO_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND BIL_TO_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'AR'" ).append("\n"); 
		query.append("      FROM SAR_RECEIPT" ).append("\n"); 
		query.append("     WHERE RCT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND RCT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Booking/BL' CNT" ).append("\n"); 
		query.append("      FROM BKG_BOOKING" ).append("\n"); 
		query.append("     WHERE BKG_PTY_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND BKG_PTY_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Booking/BL' CNT" ).append("\n"); 
		query.append("      FROM BKG_BOOKING" ).append("\n"); 
		query.append("     WHERE BKG_CTRL_PTY_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND BKG_CTRL_PTY_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Booking/BL' CNT" ).append("\n"); 
		query.append("      FROM BKG_BOOKING" ).append("\n"); 
		query.append("     WHERE AGMT_ACT_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND AGMT_ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'Booking/BL' CNT" ).append("\n"); 
		query.append("      FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("     WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("       AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  ) A" ).append("\n"); 

	}
}
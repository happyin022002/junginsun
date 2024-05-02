/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOARInvoiceCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOARInvoiceCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOARInvoiceCustomerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOARInvoiceCustomerVORSQL").append("\n"); 
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
		query.append("SELECT ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       ACT_CUST_SEQ," ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       SVC_SCP_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       BL_SRC_NO," ).append("\n"); 
		query.append("       AR_IF_NO," ).append("\n"); 
		query.append("       MN.BKG_NO," ).append("\n"); 
		query.append("       SHPR.CUST_CNT_CD SHPR_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(SHPR.CUST_SEQ,6,0) SHPR_CUST_SEQ," ).append("\n"); 
		query.append("       SHPR.CUST_NM SHPR_CUST_NM," ).append("\n"); 
		query.append("       SHPR.CUST_ADDR SHPR_CUST_ADDR," ).append("\n"); 
		query.append("       FWDR.CUST_CNT_CD FWDR_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(FWDR.CUST_SEQ,6,0) FWDR_CUST_SEQ," ).append("\n"); 
		query.append("       FWDR.CUST_NM FWDR_CUST_NM," ).append("\n"); 
		query.append("       FWDR.CUST_ADDR FWDR_CUST_ADDR," ).append("\n"); 
		query.append("       MN.BL_INV_IF_DT," ).append("\n"); 
		query.append("	   DECODE(INSTR(NVL(DECODE(SUBSTR(SHPR.CUST_NM,1,2),'TO','',SHPR.CUST_NM),FWDR.CUST_NM),' '),0,NVL(DECODE(SUBSTR(SHPR.CUST_NM,1,2),'TO','',SHPR.CUST_NM),FWDR.CUST_NM),SUBSTR(NVL(DECODE(SUBSTR(SHPR.CUST_NM,1,2),'TO','',SHPR.CUST_NM),FWDR.CUST_NM),1,INSTR(NVL(DECODE(SUBSTR(SHPR.CUST_NM,1,2),'TO','',SHPR.CUST_NM),FWDR.CUST_NM),' '))) CUST_NM," ).append("\n"); 
		query.append("	   MN.INV_RMK," ).append("\n"); 
		query.append("	   MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.IO_BND_CD," ).append("\n"); 
		query.append("	   MN.AR_OFC_CD," ).append("\n"); 
		query.append("	   MN.GL_EFF_DT," ).append("\n"); 
		query.append("	   MN.SAIL_DT" ).append("\n"); 
		query.append("  FROM INV_AR_MN    MN," ).append("\n"); 
		query.append("       MDM_CUSTOMER CUST," ).append("\n"); 
		query.append("       BKG_CUSTOMER SHPR," ).append("\n"); 
		query.append("       BKG_CUSTOMER FWDR" ).append("\n"); 
		query.append(" WHERE MN.ACT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_SEQ    = CUST.CUST_SEQ " ).append("\n"); 
		query.append("   AND MN.BKG_NO          = SHPR.BKG_NO" ).append("\n"); 
		query.append("   AND DECODE(MN.IO_BND_CD,'O','S','C') = SHPR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND MN.BKG_NO          = FWDR.BKG_NO" ).append("\n"); 
		query.append("   AND DECODE(MN.IO_BND_CD,'O','F','N') = FWDR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("   AND MN.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("   AND MN.BL_INV_IF_DT >= replace(@[from_date],'-','')" ).append("\n"); 
		query.append("   AND MN.BL_INV_IF_DT <= replace(@[to_date],'-','')" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND MN.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("   AND DECODE(MN.IO_BND_CD ,'O',MN.POL_CD,MN.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NVL(MN.INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND MN.AR_IF_NO IN (SELECT MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                         FROM INV_AR_MN" ).append("\n"); 
		query.append("                        WHERE AR_OFC_CD = @[ofc_cd]						 " ).append("\n"); 
		query.append("						  AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("                          AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                          AND NVL(INV_SPLIT_CD,'N') NOT IN ('M','X')" ).append("\n"); 
		query.append("						  --AND NVL(INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("						  AND BL_SRC_NO  IN (SELECT BL_SRC_NO" ).append("\n"); 
		query.append("                                                 FROM INV_AR_MN " ).append("\n"); 
		query.append("                                                WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                                  AND ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("                                                  AND ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("                          						  AND BL_INV_IF_DT >= replace(@[from_date],'-','')" ).append("\n"); 
		query.append("                          						  AND BL_INV_IF_DT <= replace(@[to_date],'-','')" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("                                                  AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("												  AND DECODE(IO_BND_CD ,'O',POL_CD,POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("												  AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("                          						  AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                          						  AND NVL(INV_SPLIT_CD,'N') NOT IN ('M','X')" ).append("\n"); 
		query.append("                                                  AND NVL(INV_ISS_FLG,'N') = 'N')" ).append("\n"); 
		query.append("						 " ).append("\n"); 
		query.append("                        GROUP BY BL_SRC_NO )" ).append("\n"); 

	}
}
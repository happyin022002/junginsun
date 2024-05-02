/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoByOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoByOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Integrated Customer Data Update Setup Master 생성
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoByOfcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_upd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoByOfcCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_IB_CUST_CNTC_STUP" ).append("\n"); 
		query.append(" (OFC_CD," ).append("\n"); 
		query.append("  AUTO_UPD_FLG," ).append("\n"); 
		query.append("  UPD_LOCL_DT," ).append("\n"); 
		query.append("  UPD_LOCL_GDT," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT)" ).append("\n"); 
		query.append("(SELECT   " ).append("\n"); 
		query.append("  @[ofc_cd]," ).append("\n"); 
		query.append("  @[auto_upd_flg]," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]))," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'GMT')," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(" FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 

	}
}
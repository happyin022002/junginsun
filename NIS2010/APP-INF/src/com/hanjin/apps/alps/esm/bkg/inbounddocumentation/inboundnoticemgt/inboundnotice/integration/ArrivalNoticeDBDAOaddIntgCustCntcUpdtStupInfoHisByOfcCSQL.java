/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoHisByOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoHisByOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Integrated Customer Data Update Setup History 생성
	  * </pre>
	  */
	public ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoHisByOfcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_auto_upd_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoHisByOfcCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_IB_CUST_CNTC_STUP_HIS" ).append("\n"); 
		query.append(" (OFC_CD          ," ).append("\n"); 
		query.append("  HIS_SEQ         ," ).append("\n"); 
		query.append("  OLD_AUTO_UPD_FLG," ).append("\n"); 
		query.append("  NEW_AUTO_UPD_FLG," ).append("\n"); 
		query.append("  CNG_DT          ," ).append("\n"); 
		query.append("  CNG_GDT         ," ).append("\n"); 
		query.append("  CNG_USR_ID      ," ).append("\n"); 
		query.append("  CRE_USR_ID      ," ).append("\n"); 
		query.append("  CRE_DT          ," ).append("\n"); 
		query.append("  UPD_USR_ID      ," ).append("\n"); 
		query.append("  UPD_DT)" ).append("\n"); 
		query.append("(SELECT   " ).append("\n"); 
		query.append("  @[ofc_cd]," ).append("\n"); 
		query.append("  NVL(MAX(HIS_SEQ),0) + 1," ).append("\n"); 
		query.append("  NVL(SUBSTR(MAX(LPAD(HIS_SEQ,4,'0001')||NVL(NEW_AUTO_UPD_FLG,'Y')),-1),'Y')," ).append("\n"); 
		query.append("  @[new_auto_upd_flg]," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]))," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,'GMT')," ).append("\n"); 
		query.append("  @[cng_usr_id]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(" FROM BKG_IB_CUST_CNTC_STUP_HIS" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[ofc_cd] )" ).append("\n"); 

	}
}
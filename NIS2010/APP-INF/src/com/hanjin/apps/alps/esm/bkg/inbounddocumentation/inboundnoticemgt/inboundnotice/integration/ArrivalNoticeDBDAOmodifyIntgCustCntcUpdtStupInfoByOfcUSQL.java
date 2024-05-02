/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOmodifyIntgCustCntcUpdtStupInfoByOfcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.02 
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

public class ArrivalNoticeDBDAOmodifyIntgCustCntcUpdtStupInfoByOfcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Integrated Customer Data Update Setup 저장
	  * </pre>
	  */
	public ArrivalNoticeDBDAOmodifyIntgCustCntcUpdtStupInfoByOfcUSQL(){
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
		params.put("auto_upd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOmodifyIntgCustCntcUpdtStupInfoByOfcUSQL").append("\n"); 
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
		query.append("UPDATE BKG_IB_CUST_CNTC_STUP" ).append("\n"); 
		query.append("   SET AUTO_UPD_FLG = @[auto_upd_flg]," ).append("\n"); 
		query.append("       UPD_LOCL_DT  = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd]))," ).append("\n"); 
		query.append("       UPD_LOCL_GDT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,'GMT')," ).append("\n"); 
		query.append("       UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT       = SYSDATE" ).append("\n"); 
		query.append(" WHERE OFC_CD       = @[ofc_cd]" ).append("\n"); 

	}
}
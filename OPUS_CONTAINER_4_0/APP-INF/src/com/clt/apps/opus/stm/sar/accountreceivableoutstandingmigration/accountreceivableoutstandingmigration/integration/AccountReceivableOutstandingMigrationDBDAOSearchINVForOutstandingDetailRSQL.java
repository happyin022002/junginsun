/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding Detail을 생성하기 위한 Invoice 정보를 select
	  * </pre>
	  */
	public AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingDetailRSQL").append("\n"); 
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
		query.append("SELECT  C.AR_HD_QTR_OFC_CD RHQ_CD" ).append("\n"); 
		query.append("      , DECODE(NVL(E.OTS_CD, 'ARO'), 'COU', E.REP_OTS_OFC_CD, A.AR_OFC_CD) OTS_OFC_CD" ).append("\n"); 
		query.append("      , A.LOCL_CURR_CD OFC_CURR_CD" ).append("\n"); 
		query.append("      , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("      , DECODE(D.OTS_SMRY_CD, 'INV', NVL(A.INV_NO, '**********'), '**********') INV_NO" ).append("\n"); 
		query.append("      , B.CURR_CD BL_CURR_CD" ).append("\n"); 
		query.append("      , B.CHG_CD CHG_TP_CD" ).append("\n"); 
		query.append("      , SUM(NVL(B.CHG_AMT, 0)) INV_AMT" ).append("\n"); 
		query.append("      , B.INV_XCH_RT LOCL_XCH_RT" ).append("\n"); 
		query.append("      , B.USD_XCH_RT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM    OPUSADM_TMP.INV_AR_MN A" ).append("\n"); 
		query.append("      , OPUSADM_TMP.INV_AR_CHG B" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION C" ).append("\n"); 
		query.append("      , INV_AR_STUP_OFC D" ).append("\n"); 
		query.append("      , SCO_OFC_INFO E" ).append("\n"); 
		query.append("WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = D.AR_OFC_CD(+)" ).append("\n"); 
		query.append("AND     A.AR_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("AND     D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND     A.AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("GROUP   BY C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      , E.OTS_CD" ).append("\n"); 
		query.append("      , E.REP_OTS_OFC_CD" ).append("\n"); 
		query.append("      , A.AR_OFC_CD" ).append("\n"); 
		query.append("      , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      , A.BL_SRC_NO" ).append("\n"); 
		query.append("      , D.OTS_SMRY_CD" ).append("\n"); 
		query.append("      , A.INV_NO" ).append("\n"); 
		query.append("      , B.CURR_CD" ).append("\n"); 
		query.append("      , B.CHG_CD" ).append("\n"); 
		query.append("      , B.INV_XCH_RT" ).append("\n"); 
		query.append("      , B.USD_XCH_RT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 

	}
}
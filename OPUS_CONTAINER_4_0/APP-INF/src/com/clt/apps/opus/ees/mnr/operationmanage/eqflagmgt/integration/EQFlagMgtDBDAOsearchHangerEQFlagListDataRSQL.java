/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchHangerEQFlagListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.09.21 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchHangerEQFlagListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHangerEQFlagListData
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchHangerEQFlagListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_list",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchHangerEQFlagListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" B.EQ_NO" ).append("\n"); 
		query.append(",B.EQ_TYPE EQ_KND_CD" ).append("\n"); 
		query.append(",B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_FLG,'N') MNR_HNGR_FLG" ).append("\n"); 
		query.append(",B.MVMT_CD" ).append("\n"); 
		query.append(",B.CRNT_YD_CD MNR_HNGR_FLG_YD_CD" ).append("\n"); 
		query.append(",NVL(B.HNGR_RCK_CD,'R') AS MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",DECODE(NVL(B.HNGR_RCK_CD,'R'),'O','S', NVL(B.BAR_TP_CD,'S')) AS MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_TRF_CD,'CB') AS MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append(",DECODE(A.MNR_HNGR_TRF_CD, 'OT', A.MNR_HNGR_TRF_OTR_DESC, '') AS MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append(",NVL(A.HNGR_BAR_ATCH_KNT,0) HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append(",NVL(A.ACT_INVT_QTY,0) ACT_INVT_QTY" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_DMG_QTY,0) MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append(",NVL(A.MNR_LOST_HNGR_QTY,0) MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append(",NVL(A.MNR_DISP_HNGR_QTY,0) MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append(",A.MNR_STS_RMK" ).append("\n"); 
		query.append("FROM MNR_EQ_STS A, MNR_EQ_STS_V B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.EQ_NO(+) = B.EQ_NO" ).append("\n"); 
		query.append("#if (${eq_list} != '')" ).append("\n"); 
		query.append("	AND B.EQ_NO = @[eq_list]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.26 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL
	  * </pre>
	  */
	public ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : ROUTUnMatmanageDBDAOsearchRoutUnMatSoInforDetailRSQL").append("\n"); 
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
		query.append("SELECT '' seq," ).append("\n"); 
		query.append("EQ_NO cntr_no," ).append("\n"); 
		query.append("EQ_TPSZ_CD tp_sz," ).append("\n"); 
		query.append("FM_NOD_CD||'-'||TO_NOD_CD org_dest," ).append("\n"); 
		query.append("TRSP_CRR_MOD_CD move," ).append("\n"); 
		query.append("A.CRE_OFC_CD ofc_cd," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT,'YYYY/MM/DD') so_date," ).append("\n"); 
		query.append("A.CRE_USR_ID so_user," ).append("\n"); 
		query.append("TRSP_SO_STS_CD so_sts," ).append("\n"); 
		query.append("CURR_CD curr," ).append("\n"); 
		query.append("(NVl(BZC_AMT,0)+NVL(ETC_ADD_AMT,0)+NVL(FUEL_SCG_AMT,0)+NVL(NEGO_AMT,0)) amt," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ wo_no," ).append("\n"); 
		query.append("TO_CHAR(B.CRE_DT,'YYYY/MM/DD') wo_date," ).append("\n"); 
		query.append("NVL(A.INV_BZC_AMT,0) inv_amt," ).append("\n"); 
		query.append("TRSP_INV_AUD_STS_CD inv_sts," ).append("\n"); 
		query.append("C.CRE_USR_ID inv_user," ).append("\n"); 
		query.append("A.INTER_RMK so_rmk" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD B," ).append("\n"); 
		query.append("TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("#if(${creOfcCd} != '')" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[creOfcCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.TRSP_WO_OFC_CTY_CD  =B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_WO_SEQ = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND A.INV_NO = C.INV_NO(+)" ).append("\n"); 
		query.append("AND A.INV_VNDR_SEQ = C.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y'" ).append("\n"); 

	}
}
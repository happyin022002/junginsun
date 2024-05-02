/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HangerInventoryMgtDBDAOsearchHangerInventoryDetailListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.31
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.01.31 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HangerInventoryMgtDBDAOsearchHangerInventoryDetailListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HangerInventoryMgtDBDAOsearchHangerInventoryDetailListDataRSQL
	  * </pre>
	  */
	public HangerInventoryMgtDBDAOsearchHangerInventoryDetailListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration").append("\n"); 
		query.append("FileName : HangerInventoryMgtDBDAOsearchHangerInventoryDetailListDataRSQL").append("\n"); 
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
		query.append("B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",A.HNGR_INVT_VER_NO" ).append("\n"); 
		query.append(",A.HNGR_INVT_LST_VER_FLG" ).append("\n"); 
		query.append(",A.INVT_QTY" ).append("\n"); 
		query.append(",A.MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append(",A.PUR_QTY" ).append("\n"); 
		query.append(",A.CSM_QTY" ).append("\n"); 
		query.append(",A.RCVR_QTY" ).append("\n"); 
		query.append(",A.ACT_INVT_QTY" ).append("\n"); 
		query.append(",A.MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append(",A.MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append(",A.INVT_RMK" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.UPD_DT, @[user_ofc_cd]), 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_HNGR_INVT A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND   A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("AND A.UPD_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[from_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.MNR_HNGR_BAR_TP_CD,A.CRE_DT DESC" ).append("\n"); 

	}
}
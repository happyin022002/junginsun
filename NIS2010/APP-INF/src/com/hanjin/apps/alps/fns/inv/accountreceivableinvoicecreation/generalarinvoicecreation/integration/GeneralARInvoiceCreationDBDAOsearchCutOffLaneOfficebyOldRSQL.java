/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchCutOffLaneOfficebyOldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.11
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.07.11 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchCutOffLaneOfficebyOldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCutOffLaneOfficebyOld
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchCutOffLaneOfficebyOldRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchCutOffLaneOfficebyOldRSQL").append("\n"); 
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
		query.append("SELECT A.NEW_AR_OFC_CD ar_ofc_cd" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OLD_AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND (A.IO_BND_CD='A' OR A.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("AND (A.SLAN_CD = 'ALL' OR A.SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)))" ).append("\n"); 
		query.append("AND (A.PORT_CD = 'ALL' OR A.PORT_CD = DECODE(@[io_bnd_cd], 'I', @[pod_cd], 'O', @[pol_cd]))" ).append("\n"); 
		query.append("AND A.NEW_AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.APLY_DT <= DECODE(A.cut_off_aply_dt_tp_cd,'S',@[sail_arr_dt],'I', TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.OLD_AR_OFC_CD ar_ofc_cd" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OLD_AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND (A.IO_BND_CD='A' OR A.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("AND (A.SLAN_CD = 'ALL' OR A.SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)))" ).append("\n"); 
		query.append("AND (A.PORT_CD = 'ALL' OR A.PORT_CD = DECODE(@[io_bnd_cd], 'I', @[pod_cd], 'O', @[pol_cd]))" ).append("\n"); 
		query.append("AND A.OLD_AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.APLY_DT > DECODE(A.cut_off_aply_dt_tp_cd,'S',@[sail_arr_dt],'I', TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') ='N'" ).append("\n"); 

	}
}
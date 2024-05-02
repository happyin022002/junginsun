/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchCutOffLaneOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.12.16 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchCutOffLaneOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchCutOffLaneOfficeRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchCutOffLaneOfficeRSQL").append("\n"); 
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
		query.append("#if (${tp_cd} == 'N')" ).append("\n"); 
		query.append("SELECT A.cut_off_aply_dt_tp_cd," ).append("\n"); 
		query.append("A.aply_dt, A.new_ar_ofc_cd ar_ofc_cd" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OLD_AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND (A.IO_BND_CD='A' or A.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("AND (A.SLAN_CD = 'ALL' or A.SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD =  SUBSTR(@[vvd], 9, 1)))" ).append("\n"); 
		query.append("AND (A.PORT_CD = 'ALL' or A.PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("AND A.NEW_AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.APLY_DT <= DECODE(A.cut_off_aply_dt_tp_cd,'S',@[sail_arr_dt],'I', TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("AND nvl(B.DELT_FLG,'N') ='N' -- delt flg 체크하는 로직 추가 20091210 이상희과장" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.cut_off_aply_dt_tp_cd," ).append("\n"); 
		query.append("A.aply_dt, A.old_ar_ofc_cd ar_ofc_cd" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OLD_AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND (A.IO_BND_CD='A' or A.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("AND (A.SLAN_CD = 'ALL' or A.SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD =  SUBSTR(@[vvd], 9, 1)))" ).append("\n"); 
		query.append("AND (A.PORT_CD = 'ALL' or A.PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("AND A.OLD_AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.APLY_DT > DECODE(A.cut_off_aply_dt_tp_cd,'S',@[sail_arr_dt],'I', TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("AND nvl(B.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.cut_off_aply_dt_tp_cd," ).append("\n"); 
		query.append("A.aply_dt, A.new_ar_ofc_cd ar_ofc_cd" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.NEW_AR_OFC_CD =  @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND (A.IO_BND_CD='A' or A.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("AND (A.SLAN_CD = 'ALL' or A.SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD =  SUBSTR(@[vvd], 9, 1)))" ).append("\n"); 
		query.append("AND (A.PORT_CD = 'ALL' or A.PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("AND A.NEW_AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.APLY_DT <= DECODE(A.cut_off_aply_dt_tp_cd,'S',@[sail_arr_dt],'I', TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("AND nvl(B.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.cut_off_aply_dt_tp_cd," ).append("\n"); 
		query.append("A.aply_dt, A.old_ar_ofc_cd ar_ofc_cd" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE A, MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.NEW_AR_OFC_CD =  @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND (A.IO_BND_CD='A' or A.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("AND (A.SLAN_CD = 'ALL' or A.SLAN_CD = (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD =  SUBSTR(@[vvd], 9, 1)))" ).append("\n"); 
		query.append("AND (A.PORT_CD = 'ALL' or A.PORT_CD = @[port_cd])" ).append("\n"); 
		query.append("AND A.OLD_AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.APLY_DT > DECODE(A.cut_off_aply_dt_tp_cd,'S',@[sail_arr_dt],'I', TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("AND nvl(B.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
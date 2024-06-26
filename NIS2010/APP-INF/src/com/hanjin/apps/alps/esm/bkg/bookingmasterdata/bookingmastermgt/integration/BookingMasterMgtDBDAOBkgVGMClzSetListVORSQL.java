/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgVGMClzSetListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgVGMClzSetListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VGM CCT 조회를 위한 쿼리
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgVGMClzSetListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgVGMClzSetListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	VSL_SLAN_CD" ).append("\n"); 
		query.append(",	CONTI_CD" ).append("\n"); 
		query.append(",   LOC_CD" ).append("\n"); 
		query.append(",	DECODE(YD_CD,'*','ALL',YD_CD) YD_CD" ).append("\n"); 
		query.append(",	DEST_CNT_CD" ).append("\n"); 
		query.append(",	VGM_CLZ_TP_CD" ).append("\n"); 
		query.append(",	VGM_ITVAL_HRS" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	DECODE(NVL(XCLD_HOL_FLG,' '),'Y','1','0') HOL_CHK" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",	'Hour' HOUR " ).append("\n"); 
		query.append(",	DECODE(NVL(VGM_CLZ_TP_CD,' '),'A','1','0') ETA" ).append("\n"); 
		query.append(",	DECODE(NVL(VGM_CLZ_TP_CD,' '),'B','1','0') ETB" ).append("\n"); 
		query.append(",	DECODE(NVL(VGM_CLZ_TP_CD,' '),'D','1','0') ETD" ).append("\n"); 
		query.append(",	DECODE(NVL(VGM_CLZ_TP_CD,' '),'Y','1','0') DAY" ).append("\n"); 
		query.append(",	'' CHK_OP" ).append("\n"); 
		query.append(",	(SELECT USR_NM FROM COM_USER WHERE USR_ID = CRE_USR_ID) USR_NM" ).append("\n"); 
		query.append(",	COM.OFC_CD" ).append("\n"); 
		query.append(",	VGM_CLZ_DY_CD" ).append("\n"); 
		query.append(",	concat(lpad(trunc(VGM_CLZ_DY_HRS / 60),2,'0'),lpad(mod(VGM_CLZ_DY_HRS , 60),2,'0')) VGM_CLZ_DY_HRS" ).append("\n"); 
		query.append(",	DECODE(VVD_CD,'*','ALL',VVD_CD) VVD_CD" ).append("\n"); 
		query.append("FROM BKG_VRFD_WGT_CLZ_SET A, COM_USER COM" ).append("\n"); 
		query.append("WHERE LOC_CD LIKE '%' || @[loc_cd] || '%'" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("AND	YD_CD = DECODE(@[yd_cd],'ALL','*',@[yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND	VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_cnt_cd} != '') " ).append("\n"); 
		query.append("AND	DEST_CNT_CD = @[dest_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conti_cd} != '') " ).append("\n"); 
		query.append("AND	CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("AND	VVD_CD = DECODE(@[vvd_cd],'ALL','*',@[vvd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_op} == 'Y') " ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = COM.USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
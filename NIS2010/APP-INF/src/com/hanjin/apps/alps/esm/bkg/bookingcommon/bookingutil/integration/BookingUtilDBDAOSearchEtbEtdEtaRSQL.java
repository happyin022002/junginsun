/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchEtbEtdEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.21
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.21 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchEtbEtdEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsk의 vessel schedule을 조회한다
	  * </pre>
	  */
	public BookingUtilDBDAOSearchEtbEtdEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchEtbEtdEtaRSQL").append("\n"); 
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
		query.append("VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	VPS_PORT_CD" ).append("\n"); 
		query.append(",	CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	CLPT_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",	PF_ETA_DT" ).append("\n"); 
		query.append(",	PF_ETB_DT" ).append("\n"); 
		query.append(",	PF_ETD_DT" ).append("\n"); 
		query.append(",	INIT_ETA_DT" ).append("\n"); 
		query.append(",	INIT_ETB_DT" ).append("\n"); 
		query.append(",	INIT_ETD_DT" ).append("\n"); 
		query.append(",	VPS_ETA_DT" ).append("\n"); 
		query.append(",	VPS_ETB_DT" ).append("\n"); 
		query.append(",	VPS_ETD_DT" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",	VPS_PORT_CD" ).append("\n"); 
		query.append(",	SHP_CALL_NO" ).append("\n"); 
		query.append(",	SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append(",	SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append(",	TML_VSL_CD" ).append("\n"); 
		query.append(",	TML_VOY_NO" ).append("\n"); 
		query.append(",	FT_DT" ).append("\n"); 
		query.append(",	PLISM_YD_CD" ).append("\n"); 
		query.append(",	PLISM_VSL_CD" ).append("\n"); 
		query.append(",	PLISM_VOY_NO" ).append("\n"); 
		query.append(",	SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",	TURN_PORT_FLG" ).append("\n"); 
		query.append(",	TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",	TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	IB_CGO_QTY" ).append("\n"); 
		query.append(",	OB_CGO_QTY" ).append("\n"); 
		query.append("--,	CRN_WRK_CMNC_DT" ).append("\n"); 
		query.append("--,	CRN_WRK_CMPL_DT" ).append("\n"); 
		query.append(",	VPS_RMK" ).append("\n"); 
		query.append(",	PHS_IO_RSN_CD" ).append("\n"); 
		query.append(",	PHS_IO_RMK" ).append("\n"); 
		query.append(",	SKD_BRTH_NO" ).append("\n"); 
		query.append(",	INIT_SKD_INP_FLG" ).append("\n"); 
		query.append(",	OFC_INP_FLG" ).append("\n"); 
		query.append(",	NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(",	DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(",	ACT_INP_FLG" ).append("\n"); 
		query.append(",	PRT_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("WHERE	A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	A.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '')" ).append("\n"); 
		query.append("AND	A.CLPT_IND_SEQ	= trim(@[clpt_ind_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	A.CLPT_IND_SEQ	=	(	SELECT 	MAX(B.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("FROM 	VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE 	B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND 	B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD = A.VPS_PORT_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
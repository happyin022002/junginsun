/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchBlListByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.07.15 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author An Jin Eung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchBlListByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container No로 조회시 연계된 B/L이 LCL인 경우, 관련 B/L List를 조회하고 LCL이 아닌 경우
	  *  단건의 B/L 정보를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchBlListByCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchBlListByCntrNoRSQL").append("\n"); 
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
		query.append("A.BKG_NO" ).append("\n"); 
		query.append(",	A.PCK_QTY" ).append("\n"); 
		query.append(",	A.PCK_TP_CD" ).append("\n"); 
		query.append(",	A.MEAS_QTY" ).append("\n"); 
		query.append(",	A.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A.ACT_WGT" ).append("\n"); 
		query.append(",	A.WGT_UT_CD" ).append("\n"); 
		query.append(",	A.ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(",	A.HBL_TTL_KNT" ).append("\n"); 
		query.append(",	A.SPCL_CGO_AUTH_KNT" ).append("\n"); 
		query.append(",	A.BL_OBRD_TP_CD" ).append("\n"); 
		query.append(",	A.BL_OBRD_DT" ).append("\n"); 
		query.append(",	A.AUD_ERR_CTNT" ).append("\n"); 
		query.append(",	A.IB_MF_CFM_FLG" ).append("\n"); 
		query.append(",	A.BIS_SYS_FLG" ).append("\n"); 
		query.append(",	A.ORG_CNT_NM" ).append("\n"); 
		query.append(",	A.POR_CD" ).append("\n"); 
		query.append(",	A.POR_NM" ).append("\n"); 
		query.append(",	A.POL_CD" ).append("\n"); 
		query.append(",	A.POL_NM" ).append("\n"); 
		query.append(",	A.POD_CD" ).append("\n"); 
		query.append(",	A.POD_NM" ).append("\n"); 
		query.append(",	A.DEL_CD" ).append("\n"); 
		query.append(",	A.DEL_NM" ).append("\n"); 
		query.append(",	A.BL_MV_TP_NM" ).append("\n"); 
		query.append(",	A.FNL_DEST_NM" ).append("\n"); 
		query.append(",	A.VSL_NM" ).append("\n"); 
		query.append(",	A.PRE_VSL_NM" ).append("\n"); 
		query.append(",	A.BL_CVRD_TP_CD" ).append("\n"); 
		query.append(",	A.MST_CVRD_BL_NO" ).append("\n"); 
		query.append("--,	A.MST_CVRD_BL_NO_TP" ).append("\n"); 
		query.append("--,	A.MST_CVRD_BL_NO_CHK" ).append("\n"); 
		query.append("--,	A.CDR_VSL_CD" ).append("\n"); 
		query.append("--,	A.CDR_SKD_VOY_NO" ).append("\n"); 
		query.append("--,	A.CDR_SKD_DIR_CD" ).append("\n"); 
		query.append("--,	A.CDR_POL_CD" ).append("\n"); 
		query.append("--,	A.CDR_POD_CD" ).append("\n"); 
		query.append("--,	A.CDR_FLG" ).append("\n"); 
		query.append("--,	A.CDR_CNG_FLG" ).append("\n"); 
		query.append("--,	A.RCDR_DT" ).append("\n"); 
		query.append(",	A.BDR_FLG" ).append("\n"); 
		query.append(",	A.BDR_DT" ).append("\n"); 
		query.append(",	A.BDR_CNG_FLG" ).append("\n"); 
		query.append(",	A.CORR_NO" ).append("\n"); 
		query.append(",	A.CORR_USR_ID" ).append("\n"); 
		query.append(",	A.CORR_OFC_CD" ).append("\n"); 
		query.append(",	A.CORR_N1ST_DT" ).append("\n"); 
		query.append(",	A.CORR_DT" ).append("\n"); 
		query.append(",	A.CORR_RMK" ).append("\n"); 
		query.append(",	A.BKG_CLZ_FLG" ).append("\n"); 
		query.append(",	A.BKG_CLZ_CNG_FLG" ).append("\n"); 
		query.append(",	A.BKG_CLZ_CNG_CFM_FLG" ).append("\n"); 
		query.append(",	A.TTL_PCK_DESC" ).append("\n"); 
		query.append(",	A.CSTMS_DESC" ).append("\n"); 
		query.append(",	A.MK_DESC_CFM_FLG" ).append("\n"); 
		query.append(",	A.PCK_CMDT_DESC" ).append("\n"); 
		query.append(",	A.CNTR_CMDT_DESC" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	B.CNTR_NO" ).append("\n"); 
		query.append(",	C.BL_NO" ).append("\n"); 
		query.append(",   C.BL_TP_CD" ).append("\n"); 
		query.append("FROM BKG_BL_DOC A" ).append("\n"); 
		query.append(",	BKG_CONTAINER  B" ).append("\n"); 
		query.append(",   BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND  A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND	B.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("AND B.CNMV_CYC_NO  = (SELECT MAX(CNMV_CYC_NO) FROM  BKG_CONTAINER WHERE CNTR_NO = @[cntr_no])" ).append("\n"); 

	}
}
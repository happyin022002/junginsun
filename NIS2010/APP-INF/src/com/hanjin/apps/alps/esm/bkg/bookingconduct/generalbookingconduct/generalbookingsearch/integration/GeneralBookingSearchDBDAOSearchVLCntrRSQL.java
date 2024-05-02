/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchVLCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.11.17 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchVLCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVLCntr
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchVLCntrRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchVLCntrRSQL").append("\n"); 
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
		query.append("select  substr(cntr.cntr_no,  1,10) cntr_no" ).append("\n"); 
		query.append(", substr(cntr.cntr_no,11,1) cntr_no_PST" ).append("\n"); 
		query.append(", cntr.cntr_no          full_cntr_no" ).append("\n"); 
		query.append(", cntr.cntr_tpsz_cd     TPSZ_CD" ).append("\n"); 
		query.append(", mvmt.MVMT_STS_CD      STS_CD" ).append("\n"); 
		query.append(", edi.BKG_POD_CD        POD_CD" ).append("\n"); 
		query.append(", cntr.pre_sts_flg" ).append("\n"); 
		query.append("FROM ctm_movement mvmt" ).append("\n"); 
		query.append(", mst_container cntr" ).append("\n"); 
		query.append(", mdm_vsl_cntr vsl" ).append("\n"); 
		query.append(", CTM_MVMT_EDI_MSG edi" ).append("\n"); 
		query.append("WHERE mvmt.cntr_no         = cntr.cntr_no" ).append("\n"); 
		query.append("and mvmt.CNMV_CYC_NO     = cntr.cnmv_cyc_no" ).append("\n"); 
		query.append("and mvmt.ORG_YD_CD       = cntr.CRNT_YD_CD" ).append("\n"); 
		query.append("and cntr.CRNT_YD_CD      like @[yd_cd]||'%'" ).append("\n"); 
		query.append("and mvmt.BKG_CGO_TP_CD   = 'P'" ).append("\n"); 
		query.append("and mvmt.MVMT_STS_CD     = 'VL'" ).append("\n"); 
		query.append("and mvmt.PRE_STS_FLG     = 'Y'" ).append("\n"); 
		query.append("and mvmt.MVMT_EDI_TP_CD      = EDI.MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("AND mvmt.MVMT_EDI_MSG_TP_ID  = EDI.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("AND mvmt.MVMT_EDI_MSG_AREA_CD= EDI.MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("AND mvmt.MVMT_EDI_MSG_YRMONDY= EDI.MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("AND mvmt.MVMT_EDI_MSG_SEQ    = EDI.MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("and VSl.VSL_CD            = SUBSTR(@[vvd], 0,4)" ).append("\n"); 
		query.append("and ( mvmt.CRNT_VSL_CD    = VSl.VSL_CD" ).append("\n"); 
		query.append("or mvmt.CALL_SGN_NO = VSL.CALL_SGN_NO" ).append("\n"); 
		query.append("or mvmt.LLOYD_NO    = VSl.LLOYD_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("order by mvmt.cntr_no" ).append("\n"); 

	}
}
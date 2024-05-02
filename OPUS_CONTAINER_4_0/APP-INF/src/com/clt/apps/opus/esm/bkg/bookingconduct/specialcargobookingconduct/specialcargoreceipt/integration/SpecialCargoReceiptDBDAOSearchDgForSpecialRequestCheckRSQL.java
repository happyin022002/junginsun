/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchDgForSpecialRequestCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.05.13 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchDgForSpecialRequestCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search DG data to check special request
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchDgForSpecialRequestCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchDgForSpecialRequestCheckRSQL").append("\n"); 
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
		query.append("SELECT   BKG.BKG_NO" ).append("\n"); 
		query.append("		,BKG.VSL_CD" ).append("\n"); 
		query.append("		,BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("		,BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("		,BKG.POL_CD" ).append("\n"); 
		query.append("		,BKG.POD_CD" ).append("\n"); 
		query.append("		,VSL.CRR_CD" ).append("\n"); 
		query.append("		,'' SLAN_CD" ).append("\n"); 
		query.append("		,'' OPT_CLSS" ).append("\n"); 
		query.append("		,DG.IMDG_UN_NO" ).append("\n"); 
		query.append("		,DG.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		,DG.IMDG_CLSS_CD" ).append("\n"); 
		query.append("		,DG.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("		,DG.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("		,DG.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("		,DG.DG_CNTR_SEQ " ).append("\n"); 
		query.append("		,DG.CNTR_CGO_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("	,BKG_DG_CGO DG" ).append("\n"); 
		query.append("	,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("AND BKG.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("AND NVL(DG.SPCL_CGO_APRO_CD, 'A') <> 'C'" ).append("\n"); 

	}
}
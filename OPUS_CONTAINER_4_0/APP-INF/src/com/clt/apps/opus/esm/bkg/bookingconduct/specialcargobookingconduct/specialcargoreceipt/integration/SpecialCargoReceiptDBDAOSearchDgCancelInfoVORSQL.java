/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchDgCancelInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.08.11 Maeda Atsushi
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

public class SpecialCargoReceiptDBDAOSearchDgCancelInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDgCancelInfoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchDgCancelInfoVORSQL(){
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
		query.append("FileName : SpecialCargoReceiptDBDAOSearchDgCancelInfoVORSQL").append("\n"); 
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
		query.append("	 VVD.BKG_NO" ).append("\n"); 
		query.append("	,VVD.VSL_CD" ).append("\n"); 
		query.append("	,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("	,VVD.POL_CD" ).append("\n"); 
		query.append("	,VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,VVD.POL_YD_CD" ).append("\n"); 
		query.append("	,VVD.POD_CD" ).append("\n"); 
		query.append("	,VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,VVD.POD_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_VVD VVD" ).append("\n"); 
		query.append("	,MDM_VSL_SVC_LANE LANE" ).append("\n"); 
		query.append("WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VVD.SLAN_CD = LANE.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND LANE.SPCL_CGO_RQST_TGT_LANE_FLG = 'Y'" ).append("\n"); 
		query.append("AND LANE.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND EXISTS( " ).append("\n"); 
		query.append("	SELECT * " ).append("\n"); 
		query.append("	FROM BKG_DG_CGO DG " ).append("\n"); 
		query.append("	WHERE DG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}
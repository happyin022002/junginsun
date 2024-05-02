/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : COPSearchDBDAOSearchSceCopHdrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchSceCopHdrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop inquiry
	  * </pre>
	  */
	public COPSearchDBDAOSearchSceCopHdrInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchSceCopHdrInfoRSQL").append("\n"); 
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
		query.append("SELECT '' chk " ).append("\n"); 
		query.append("     , DECODE(COP_NO, MST_COP_NO, 'P', 'X') AS MST_LCL_CD" ).append("\n"); 
		query.append("     , HDR.CNTR_NO" ).append("\n"); 
		query.append("     , HDR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , HDR.CNMV_YR" ).append("\n"); 
		query.append("     , '' AS CNMV_SEQ" ).append("\n"); 
		query.append("     , hdr.BKG_NO" ).append("\n"); 
		query.append("     , COP_STS_CD " ).append("\n"); 
		query.append("     , cntr.CNTR_VOL_QTY" ).append("\n"); 
		query.append("     , COP_NO" ).append("\n"); 
		query.append("     , hdr.PCTL_NO" ).append("\n"); 
		query.append("     , '' AS OB_PCTL_NO" ).append("\n"); 
		query.append("     , '' AS IB_PCTL_NO" ).append("\n"); 
		query.append("     , bk.POL_CD" ).append("\n"); 
		query.append("     , bk.POD_CD" ).append("\n"); 
		query.append("     , bk.POR_CD" ).append("\n"); 
		query.append("     , bk.DEL_CD" ).append("\n"); 
		query.append("     , hdr.TRNK_VSL_CD" ).append("\n"); 
		query.append("     , hdr.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("     , hdr.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("     , prd.DG_SPCL_FLG" ).append("\n"); 
		query.append("     , prd.RF_SPCL_FLG" ).append("\n"); 
		query.append("     , prd.SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("     , prd.BB_SPCL_FLG" ).append("\n"); 
		query.append("     , prd.RD_SPCL_FLG" ).append("\n"); 
		query.append("     , prd.HNGR_SPCL_FLG" ).append("\n"); 
		query.append("     , bk.SOC_FLG	" ).append("\n"); 
		query.append("     , bk.bkg_sts_cd				" ).append("\n"); 
		query.append(" FROM sce_cop_hdr hdr" ).append("\n"); 
		query.append("     ,bkg_booking bk" ).append("\n"); 
		query.append("     ,prd_prod_ctl_mst prd" ).append("\n"); 
		query.append("     ,bkg_container cntr" ).append("\n"); 
		query.append("WHERE hdr.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("  AND hdr.pctl_no = prd.pctl_no" ).append("\n"); 
		query.append("  AND hdr.bkg_no = cntr.bkg_no(+)" ).append("\n"); 
		query.append("  AND hdr.cntr_no = cntr.cntr_no(+)" ).append("\n"); 
		query.append("  AND hdr.cntr_no = @[cntr_no]	" ).append("\n"); 
		query.append("  AND hdr.cntr_no <> 'COMU0000000'	" ).append("\n"); 
		query.append("  AND hdr.CNMV_YR BETWEEN  TO_CHAR( TO_NUMBER( TO_CHAR(SYSDATE, 'YYYY' ) ) - 2 )  and  TO_CHAR(SYSDATE, 'YYYY' )" ).append("\n"); 

	}
}
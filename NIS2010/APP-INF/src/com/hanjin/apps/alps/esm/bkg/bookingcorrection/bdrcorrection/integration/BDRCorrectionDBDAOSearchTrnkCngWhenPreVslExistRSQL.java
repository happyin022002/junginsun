/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchTrnkCngWhenPreVslExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.09.15 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchTrnkCngWhenPreVslExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchTrnkCngWhenPreVslExistRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchTrnkCngWhenPreVslExistRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchTrnkCngWhenPreVslExistRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') TRNK_CNG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(", BKG_BKG_HIS BKG_HIS" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO      = BKG_HIS.BKG_NO" ).append("\n"); 
		query.append("AND BKG_HIS.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BKG.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND ( BKG.VSL_CD     != BKG_HIS.VSL_CD" ).append("\n"); 
		query.append("OR BKG.SKD_VOY_NO != BKG_HIS.SKD_VOY_NO" ).append("\n"); 
		query.append("OR BKG.SKD_DIR_CD != BKG_HIS.SKD_DIR_CD )" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS BVH" ).append("\n"); 
		query.append("WHERE BVH.BKG_NO     = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BVH.CORR_NO    = 'TMP0000001'" ).append("\n"); 
		query.append("AND VSL_PRE_PST_CD = 'S' )" ).append("\n"); 

	}
}
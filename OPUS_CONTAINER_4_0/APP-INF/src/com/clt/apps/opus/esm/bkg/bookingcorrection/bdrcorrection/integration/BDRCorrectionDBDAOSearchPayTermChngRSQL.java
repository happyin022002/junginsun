/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchPayTermChngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchPayTermChngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchPayTermChngRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchPayTermChngRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchPayTermChngRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') CHN_FLG" ).append("\n"); 
		query.append("FROM BKG_CHG_RT     BKGRT" ).append("\n"); 
		query.append(", BKG_CHG_RT_HIS BKGRTHIS" ).append("\n"); 
		query.append("WHERE BKGRT.BKG_NO      = BKGRTHIS.BKG_NO" ).append("\n"); 
		query.append("AND BKGRT.RT_SEQ      = BKGRTHIS.RT_SEQ" ).append("\n"); 
		query.append("AND BKGRT.CHG_CD      = BKGRTHIS.CHG_CD" ).append("\n"); 
		query.append("AND BKGRT.FRT_TERM_CD != BKGRTHIS.FRT_TERM_CD" ).append("\n"); 
		query.append("AND BKGRTHIS.CORR_NO  = 'TMP0000001'" ).append("\n"); 
		query.append("AND BKGRT.BKG_NO      = @[bkg_no]" ).append("\n"); 

	}
}
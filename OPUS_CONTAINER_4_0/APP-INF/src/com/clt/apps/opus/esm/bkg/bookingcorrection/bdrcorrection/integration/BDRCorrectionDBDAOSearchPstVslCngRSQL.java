/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchPstVslCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.09.15 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchPstVslCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchPstVslCngRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchPstVslCngRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration ").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchPstVslCngRSQL").append("\n"); 
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
		query.append("FROM ( SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("AND VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
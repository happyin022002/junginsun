/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchVslSkipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.09.21 이남경
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

public class BDRCorrectionDBDAOSearchVslSkipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchVslSkipRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchVslSkipRSQL(){
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
		query.append("FileName : BDRCorrectionDBDAOSearchVslSkipRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') VSLSKIP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_VVD          VVD" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append("WHERE VVD.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND VVD.VSL_CD           = VVPS.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO       = VVPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD       = VVPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD           = VVPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POD_CLPT_IND_SEQ = VVPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND VVPS.SKD_CNG_STS_CD  = 'S'" ).append("\n"); 
		query.append("AND VVPS.USD_FLG IN ('B','H')" ).append("\n"); 
		query.append("AND EXISTS (SELECT POD_CD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO  = VVD.BKG_NO" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT POD_CD" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = VVD.BKG_NO" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_VVD          VVD" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append("WHERE VVD.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND VVD.VSL_CD           = VVPS.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO       = VVPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD       = VVPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD           = VVPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POD_CLPT_IND_SEQ = VVPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND VVPS.SKD_CNG_STS_CD  = 'S'" ).append("\n"); 
		query.append("AND VVPS.USD_FLG IN ('B','H')" ).append("\n"); 
		query.append("AND EXISTS (SELECT POD_CD" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = VVD.BKG_NO" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT POD_CD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO  = VVD.BKG_NO)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
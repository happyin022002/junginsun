/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKrBl
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrBlRSQL(){
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
		params.put("whf_rate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrBlRSQL").append("\n"); 
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
		query.append(" A.BL_NO" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append("--,A.VSL_CD" ).append("\n"); 
		query.append("--,A.SKD_VOY_NO" ).append("\n"); 
		query.append("--,A.SKD_DIR_CD" ).append("\n"); 
		query.append(",SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append(",SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append(",SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",A.POR_CD" ).append("\n"); 
		query.append(",A.DEL_CD" ).append("\n"); 
		query.append(",A.BKG_STS_CD" ).append("\n"); 
		query.append(",A.RCV_TERM_CD" ).append("\n"); 
		query.append(",A.DE_TERM_CD" ).append("\n"); 
		query.append(",B.PCK_QTY" ).append("\n"); 
		query.append(",B.PCK_TP_CD" ).append("\n"); 
		query.append(",B.ACT_WGT" ).append("\n"); 
		query.append(",B.WGT_UT_CD" ).append("\n"); 
		query.append(",B.MEAS_QTY" ).append("\n"); 
		query.append(",B.MEAS_UT_CD" ).append("\n"); 
		query.append(",( CASE WHEN @[whf_bnd_cd] = 'IT' THEN CEIL(TRUNC(B.ACT_WGT / 1000, 3))" ).append("\n"); 
		query.append(" WHEN TRUNC(B.ACT_WGT / 1000, 3) > TRUNC(B.MEAS_QTY / 1.333, 3) THEN CEIL(TRUNC(B.ACT_WGT / 1000, 3))" ).append("\n"); 
		query.append(" ELSE CEIL(TRUNC(B.MEAS_QTY / 1.333, 3))" ).append("\n"); 
		query.append(" END ) AS REVENUE" ).append("\n"); 
		query.append(",TRUNC(( CASE WHEN @[whf_bnd_cd] = 'IT' THEN CEIL(TRUNC(B.ACT_WGT / 1000, 3))" ).append("\n"); 
		query.append(" WHEN TRUNC(B.ACT_WGT / 1000, 3) > TRUNC(B.MEAS_QTY / 1.333, 3) THEN CEIL(TRUNC(B.ACT_WGT / 1000, 3))" ).append("\n"); 
		query.append(" ELSE CEIL(TRUNC(B.MEAS_QTY / 1.333, 3))" ).append("\n"); 
		query.append(" END ) * @[whf_rate], 0) AS AMOUNT" ).append("\n"); 
		query.append("--,CASE WHEN C.POD_CD = A.POD_CD THEN 'II'" ).append("\n"); 
		query.append("--      WHEN C.POL_CD = A.POL_CD THEN 'OO'" ).append("\n"); 
		query.append("--      WHEN SUBSTR(C.POD_CD, 1,2) = 'KR' THEN 'IT'" ).append("\n"); 
		query.append("--      WHEN SUBSTR(C.POL_CD, 1,2) = 'KR' THEN 'OT'" ).append("\n"); 
		query.append("--      ELSE '' END AS WHF_BND_CD" ).append("\n"); 
		query.append(",@[whf_bnd_cd] AS WHF_BND_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND A.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 

	}
}
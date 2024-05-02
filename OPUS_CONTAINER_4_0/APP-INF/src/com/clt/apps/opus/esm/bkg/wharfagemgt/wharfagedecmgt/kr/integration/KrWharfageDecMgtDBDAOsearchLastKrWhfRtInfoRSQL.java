/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchLastKrWhfRtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.20 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchLastKrWhfRtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchLastKrWhfRtInfoRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchLastKrWhfRtInfoRSQL").append("\n"); 
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
		query.append("--SELECT C.CHG_RT_SEQ, C.AR_IF_FLG, C.NEW_CHG_AMT, C.DIFF_AMT, C.AR_IF_FLG, C.WHF_DECL_IF_FLG" ).append("\n"); 
		query.append("SELECT NVL(MAX(C.CHG_RT_SEQ), 0) AS CHG_RT_SEQ," ).append("\n"); 
		query.append("NVL(MAX(C.AR_IF_FLG), 'N') AS AR_IF_FLG," ).append("\n"); 
		query.append("NVL(MAX(C.NEW_CHG_AMT), 0) AS NEW_CHG_AMT," ).append("\n"); 
		query.append("NVL(MAX(C.DIFF_AMT), 0) AS DIFF_AMT," ).append("\n"); 
		query.append("NVL(MAX(C.WHF_DECL_IF_FLG), 'N') AS WHF_DECL_IF_FLG" ).append("\n"); 
		query.append("FROM (SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, MAX(A.CHG_RT_SEQ) CHG_RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_RT A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD       = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND A.WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append("AND A.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO) B, BKG_KR_WHF_RT C" ).append("\n"); 
		query.append("WHERE C.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.WHF_BND_CD = B.WHF_BND_CD" ).append("\n"); 
		query.append("AND C.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND C.CHG_RT_SEQ = B.CHG_RT_SEQ" ).append("\n"); 

	}
}
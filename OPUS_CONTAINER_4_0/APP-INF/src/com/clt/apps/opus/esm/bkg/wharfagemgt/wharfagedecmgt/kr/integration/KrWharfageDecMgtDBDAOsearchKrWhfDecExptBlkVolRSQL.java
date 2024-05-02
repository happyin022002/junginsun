/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecExptBlkVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.12 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecExptBlkVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecExptBlkVolRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("size_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecExptBlkVolRSQL").append("\n"); 
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
		query.append("SELECT SUM(CASE WHEN @[size_id] = '20' THEN BB.BLK_TEU_QTY" ).append("\n"); 
		query.append("WHEN @[size_id] = '40' THEN BB.BLK_FEU_QTY" ).append("\n"); 
		query.append("WHEN @[size_id] = '45' THEN BB.BLK_45FT_QTY" ).append("\n"); 
		query.append("END) AS BLK_QTY" ).append("\n"); 
		query.append("FROM (SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, MAX(CHG_RT_SEQ) CHG_RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("AND A.WHF_BL_STS_CD != 'D'" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.KR_WHF_EXPT_CD = 'B'" ).append("\n"); 
		query.append("AND B.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO) AA," ).append("\n"); 
		query.append("BKG_KR_WHF_RT BB" ).append("\n"); 
		query.append("WHERE BB.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("AND BB.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BB.SKD_DIR_CD = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BB.WHF_BND_CD = AA.WHF_BND_cD" ).append("\n"); 
		query.append("AND BB.BL_NO = AA.BL_NO" ).append("\n"); 
		query.append("AND BB.CHG_RT_SEQ = AA.CHG_RT_SEQ" ).append("\n"); 

	}
}
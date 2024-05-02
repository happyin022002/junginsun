/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtWhfDecUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.11.24 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtWhfDecUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * m
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtWhfDecUSQL(){
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
		params.put("whf_ntc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmodifyBkgKrWhfRtWhfDecUSQL").append("\n"); 
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
		query.append("UPDATE BKG_KR_WHF_RT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("WHF_NTC_NO = @[whf_ntc_no]" ).append("\n"); 
		query.append("WHERE (BL_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, WHF_BND_CD, CHG_RT_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.BL_NO,      B.VSL_CD," ).append("\n"); 
		query.append("B.SKD_VOY_NO, B.SKD_DIR_CD," ).append("\n"); 
		query.append("B.WHF_BND_CD, MAX(CHG_RT_SEQ) SEQ" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.VSL_CD      = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO  = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD  = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND A.WHF_BND_CD  in (DECODE(@[whf_bnd_cd],'IN','II', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT',@[whf_bnd_cd]))" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd],1,1),'I',A.WHF_POD_CD,'O',A.WHF_POL_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD  = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.WHF_BND_CD  = A.WHF_BND_CD" ).append("\n"); 
		query.append("AND B.BL_NO       = A.BL_NO" ).append("\n"); 
		query.append("AND NVL(A.WHF_BL_STS_CD, ' ') != 'D'" ).append("\n"); 
		query.append("AND NVL(A.WHF_BL_THRU_TS_FLG, 'N') != 'T'" ).append("\n"); 
		query.append("GROUP BY B.BL_NO, B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.WHF_BND_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
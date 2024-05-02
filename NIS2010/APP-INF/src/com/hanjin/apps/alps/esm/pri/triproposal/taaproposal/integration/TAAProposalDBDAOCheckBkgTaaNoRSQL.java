/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TAAProposalDBDAOCheckBkgTaaNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.03.18 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOCheckBkgTaaNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BOOKING 테이블에서 사용하고 있는 TAA_NO 인지 체크함
	  * </pre>
	  */
	public TAAProposalDBDAOCheckBkgTaaNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOCheckBkgTaaNoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BK.BKG_NO" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("       , BKG_RATE BR" ).append("\n"); 
		query.append("    WHERE BK.TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("    AND   BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("    AND   BR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    AND   BR.RT_APLY_DT BETWEEN TO_DATE(REPLACE(@[eff_dt],'-',''),'YYYYMMDD') " ).append("\n"); 
		query.append("                        AND TO_DATE(REPLACE(@[exp_dt],'-','')||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    ORDER BY BK.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM < 7" ).append("\n"); 

	}
}
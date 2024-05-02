/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOModifyOfficeExpenseMatrixUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.24 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOModifyOfficeExpenseMatrixUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용계획 수립을 위하여 사용할 비용코드를 조직별로 매핑 정보 수정
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOModifyOfficeExpenseMatrixUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE GEM_OFC_MTX" ).append("\n"); 
		query.append("SET DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOModifyOfficeExpenseMatrixUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
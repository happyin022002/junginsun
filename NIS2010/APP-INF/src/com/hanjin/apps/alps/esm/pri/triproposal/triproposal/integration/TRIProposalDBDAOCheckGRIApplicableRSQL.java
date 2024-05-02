/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOCheckGRIApplicableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.04 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOCheckGRIApplicableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI가 적용가능한지(진행중인게 있는지) 확인
	  * </pre>
	  */
	public TRIProposalDBDAOCheckGRIApplicableRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOCheckGRIApplicableRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(A.TRI_NO, 1, 6) || '-' || SUBSTR(A.TRI_NO, 7, 4) || '-' || SUBSTR(A.TRI_NO, 11, 3) AS TRI_NO" ).append("\n"); 
		query.append("FROM PRI_TRI_MN A, PRI_TRI_RT B" ).append("\n"); 
		query.append("WHERE A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND B.PROP_STS_CD = 'I'" ).append("\n"); 
		query.append("AND B.GRI_APPL_TP_CD = 'A'" ).append("\n"); 

	}
}
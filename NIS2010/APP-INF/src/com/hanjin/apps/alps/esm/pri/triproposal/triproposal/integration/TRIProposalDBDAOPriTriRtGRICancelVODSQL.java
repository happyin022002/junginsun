/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriRtGRICancelVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.23 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriRtGRICancelVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Cancel
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriRtGRICancelVODSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration ").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriRtGRICancelVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_TRI_RT A" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_TRI_MN S" ).append("\n"); 
		query.append("WHERE S.TRI_PROP_NO = A.TRI_PROP_NO" ).append("\n"); 
		query.append("AND S.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND S.TRF_NO = @[trf_no])" ).append("\n"); 
		query.append("AND A.PROP_STS_CD = 'I'" ).append("\n"); 
		query.append("AND A.GRI_APPL_TP_CD = 'A'" ).append("\n"); 

	}
}
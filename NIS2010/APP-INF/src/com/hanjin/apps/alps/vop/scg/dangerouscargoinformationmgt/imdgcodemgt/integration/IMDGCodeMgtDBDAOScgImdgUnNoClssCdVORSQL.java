/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgUnNoClssCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.10.21 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgUnNoClssCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_IMDG_UN_NO_CLSS_CD를 조회한다.
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgUnNoClssCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgUnNoClssCdVORSQL").append("\n"); 
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
		query.append("UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD||'^'||IMDG_SEGR_GRP_STWG_TP_CD||'^'||ROW_NUMBER( ) OVER (" ).append("\n"); 
		query.append("PARTITION BY IMDG_SEGR_GRP_STWG_TP_CD" ).append("\n"); 
		query.append("ORDER BY IMDG_SEGR_GRP_STWG_TP_CD, IMDG_CLSS_CD ASC ) AS IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO_CLSS_CD" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("ORDER BY IMDG_SEGR_GRP_STWG_TP_CD" ).append("\n"); 

	}
}
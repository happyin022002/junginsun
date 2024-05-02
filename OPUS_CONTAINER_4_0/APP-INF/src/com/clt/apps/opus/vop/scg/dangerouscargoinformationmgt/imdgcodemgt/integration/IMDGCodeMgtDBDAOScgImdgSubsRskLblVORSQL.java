/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgSubsRskLblVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.22 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgSubsRskLblVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgImdgSubsRskLbl 조회
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgSubsRskLblVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgSubsRskLblVORSQL").append("\n"); 
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
		query.append("IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.26 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgImdgUnNoSegrGrp 삭제
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpDSQL(){
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
		query.append("DELETE FROM SCG_IMDG_UN_NO_SEGR_GRP" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration ").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
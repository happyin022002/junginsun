/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSettlementJooStlVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSettlementJooStlVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement시 JOO_STL_VVD의 PROC_JB_FLG를 Y로 update한다.
	  * settlement취소시 settlement내 마지막 하나까지 삭제된 경우 joo_stl_vvd의 proc_jb_flg를 N으로 update한다.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSettlementJooStlVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSettlementJooStlVvdUSQL").append("\n"); 
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
		query.append("UPDATE JOO_STL_VVD X" ).append("\n"); 
		query.append("SET    X.PROC_JB_FLG =" ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT /*+INDEX(A XPKJOO_SETTLEMENT)*/" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A" ).append("\n"); 
		query.append("WHERE A.ACCT_YRMON  = X.ACCT_YRMON" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ = X.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND   ROWNUM = 1),'N')" ).append("\n"); 
		query.append(",X.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(",X.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE X.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND   X.STL_VVD_SEQ = @[stl_vvd_seq]" ).append("\n"); 
		query.append("AND   NVL(X.PROC_JB_FLG,'N') !=" ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT /*+INDEX(A XPKJOO_SETTLEMENT)*/" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A" ).append("\n"); 
		query.append("WHERE A.ACCT_YRMON  = X.ACCT_YRMON" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ = X.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND   ROWNUM = 1),'N')" ).append("\n"); 

	}
}
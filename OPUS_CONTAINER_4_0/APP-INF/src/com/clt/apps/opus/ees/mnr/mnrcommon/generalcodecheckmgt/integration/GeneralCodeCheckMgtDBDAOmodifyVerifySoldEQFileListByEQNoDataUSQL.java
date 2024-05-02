/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifySoldEQFileListByEQNoDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.15 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyVerifySoldEQFileListByEQNoDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정 - SoldEQFile Verify EQ No
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifySoldEQFileListByEQNoDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifySoldEQFileListByEQNoDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET A.INP_MSG4 = 'UE'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND (NVL(A.INP_MSG1,' ') NOT IN (SELECT EQ_NO" ).append("\n"); 
		query.append("FROM MNR_EQ_STS" ).append("\n"); 
		query.append("WHERE MNR_DISP_FLG = 'N'" ).append("\n"); 
		query.append("AND MNR_DISP_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("--AND EQ_NO NOT IN (SELECT EQ_NO" ).append("\n"); 
		query.append("--FROM MNR_DISP_DTL)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("A.INP_MSG1 IN (SELECT EQ_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_DTL" ).append("\n"); 
		query.append("WHERE EQ_NO = A.INP_MSG1)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
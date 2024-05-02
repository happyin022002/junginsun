/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByYDDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.16 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByYDDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyEQFlagFileListByYDData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByYDDataUSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByYDDataUSQL").append("\n"); 
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
		query.append("SET INP_MSG4 = 'UY'" ).append("\n"); 
		query.append("WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.YD_CD" ).append("\n"); 
		query.append("FROM MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.INP_MSG2 = B.YD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
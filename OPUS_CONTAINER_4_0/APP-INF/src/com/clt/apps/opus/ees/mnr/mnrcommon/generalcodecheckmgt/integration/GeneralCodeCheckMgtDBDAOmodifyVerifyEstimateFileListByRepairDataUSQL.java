/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByRepairDataUSQL.java
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

public class GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByRepairDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyVerifyEstimateFileListByRepairData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByRepairDataUSQL(){
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
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByRepairDataUSQL").append("\n"); 
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
		query.append("SET A.INP_MSG4 = 'RE'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND NVL(A.INP_MSG5,'') NOT IN (SELECT EQ_CEDEX_OTR_CD" ).append("\n"); 
		query.append("FROM MNR_CEDEX_OTR_CD" ).append("\n"); 
		query.append("WHERE EQ_CEDEX_OTR_TP_CD = 'RPR')" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultDataUSQL.java
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

public class GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCalculateEstimateResultData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultDataUSQL(){
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
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultDataUSQL").append("\n"); 
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
		query.append("SET" ).append("\n"); 
		query.append("A.INP_MSG16 = NVL(A.INP_MSG16, '0')," ).append("\n"); 
		query.append("A.INP_MSG17 = NVL(A.INP_MSG17, '0')," ).append("\n"); 
		query.append("A.INP_MSG18 = NVL(A.INP_MSG18, '0')," ).append("\n"); 
		query.append("A.INP_MSG28 = TO_NUMBER(NVL(A.INP_MSG16, '0')) *" ).append("\n"); 
		query.append("TO_NUMBER(NVL(A.INP_MSG18, '0'))," ).append("\n"); 
		query.append("A.INP_MSG29 = TO_NUMBER(NVL(A.INP_MSG17, '0')) +" ).append("\n"); 
		query.append("TO_NUMBER(TO_NUMBER(NVL(A.INP_MSG16, '0')) *" ).append("\n"); 
		query.append("TO_NUMBER(NVL(A.INP_MSG18, '0')))," ).append("\n"); 
		query.append("A.INP_MSG4  = DECODE(SUBSTR(A.INP_MSG37, 1, 1)," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'NA'," ).append("\n"); 
		query.append("DECODE(SUBSTR(A.INP_MSG37, 2, 1)," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'NS'," ).append("\n"); 
		query.append("DECODE(SUBSTR(A.INP_MSG37, 3, 1)," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'NT'," ).append("\n"); 
		query.append("'SS')))" ).append("\n"); 
		query.append("WHERE   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND     A.INP_MSG4 = 'SS'" ).append("\n"); 

	}
}
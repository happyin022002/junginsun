/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgUnNoSegrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.25 이도형
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

public class IMDGCodeMgtDBDAOScgImdgUnNoSegrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgImdgUnNoSegr 조회
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgUnNoSegrListRSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_11) AS CLSS_CD_11" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_12) AS CLSS_CD_12" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_15) AS CLSS_CD_15" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_13) AS CLSS_CD_13" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_16) AS CLSS_CD_16" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_14) AS CLSS_CD_14" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_21) AS CLSS_CD_21" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_22) AS CLSS_CD_22" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_23) AS CLSS_CD_23" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_3) AS CLSS_CD_3" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_41) AS CLSS_CD_41" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_42) AS CLSS_CD_42" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_43) AS CLSS_CD_43" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_51) AS CLSS_CD_51" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_52) AS CLSS_CD_52" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_61) AS CLSS_CD_61" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_62) AS CLSS_CD_62" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_7) AS CLSS_CD_7" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_8) AS CLSS_CD_8" ).append("\n"); 
		query.append(",   MAX(CLSS_CD_9) AS CLSS_CD_9" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'1.1',IMDG_SEGR_CD) AS CLSS_CD_11" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'1.2',IMDG_SEGR_CD) AS CLSS_CD_12" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'1.5',IMDG_SEGR_CD) AS CLSS_CD_15" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'1.3',IMDG_SEGR_CD) AS CLSS_CD_13" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'1.6',IMDG_SEGR_CD) AS CLSS_CD_16" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'1.4',IMDG_SEGR_CD) AS CLSS_CD_14" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'2.1',IMDG_SEGR_CD) AS CLSS_CD_21" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'2.2',IMDG_SEGR_CD) AS CLSS_CD_22" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'2.3',IMDG_SEGR_CD) AS CLSS_CD_23" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'3',IMDG_SEGR_CD) AS CLSS_CD_3" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'4.1',IMDG_SEGR_CD) AS CLSS_CD_41" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'4.2',IMDG_SEGR_CD) AS CLSS_CD_42" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'4.3',IMDG_SEGR_CD) AS CLSS_CD_43" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'5.1',IMDG_SEGR_CD) AS CLSS_CD_51" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'5.2',IMDG_SEGR_CD) AS CLSS_CD_52" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'6.1',IMDG_SEGR_CD) AS CLSS_CD_61" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'6.2',IMDG_SEGR_CD) AS CLSS_CD_62" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'7',IMDG_SEGR_CD) AS CLSS_CD_7" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'8',IMDG_SEGR_CD) AS CLSS_CD_8" ).append("\n"); 
		query.append(",   DECODE(IMDG_CLSS_CD,'9',IMDG_SEGR_CD) AS CLSS_CD_9" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO_SEGR" ).append("\n"); 
		query.append("WHERE	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgUnNoSegrListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
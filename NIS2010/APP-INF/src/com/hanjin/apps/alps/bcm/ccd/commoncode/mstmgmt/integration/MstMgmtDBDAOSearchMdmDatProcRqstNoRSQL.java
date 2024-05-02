/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : MstMgmtDBDAOSearchMdmDatProcRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchMdmDatProcRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_DAT_PROC 테이블의 RQST_NO 를 채번한다.
	  * </pre>
	  */
	public MstMgmtDBDAOSearchMdmDatProcRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_dat_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchMdmDatProcRqstNoRSQL").append("\n"); 
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
		query.append("SELECT UPPER(@[mst_dat_subj_cd]) || 'C' || TO_CHAR(SYSDATE, 'YYYYMMDD') ||" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT LPAD( NVL(MAX(TO_NUMBER(SUBSTR(RQST_NO, 14))) + 1, 1) , 6, '0')" ).append("\n"); 
		query.append("        FROM MDM_DAT_PROC" ).append("\n"); 
		query.append("        WHERE INSTR(RQST_NO, UPPER(@[mst_dat_subj_cd])||'C'||TO_CHAR(SYSDATE, 'YYYYMMDD')) > 0" ).append("\n"); 
		query.append("        ) RQST_NO" ).append("\n"); 
		query.append("FROM DUAL " ).append("\n"); 

	}
}
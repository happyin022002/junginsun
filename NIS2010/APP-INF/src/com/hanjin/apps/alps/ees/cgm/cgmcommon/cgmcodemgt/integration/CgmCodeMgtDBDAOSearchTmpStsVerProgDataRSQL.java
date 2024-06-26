/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchTmpStsVerProgDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchTmpStsVerProgDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchTmpStsVerProgDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_expt_ver_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchTmpStsVerProgDataRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(PROP_NO)    " ).append("\n"); 
		query.append("FROM    CGM_SC_EXPT_VER_PROG SC_VER_PROG" ).append("\n"); 
		query.append("WHERE   PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("    AND SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("    AND PROG_SEQ 		=" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT  NVL(MAX(PROG_SEQ), 0)" ).append("\n"); 
		query.append("            FROM    CGM_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("            WHERE   PROP_NO         = SC_VER_PROG.PROP_NO" ).append("\n"); 
		query.append("                AND SC_EXPT_VER_SEQ = SC_VER_PROG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    AND CHSS_EXPT_VER_STS_CD = @[chss_expt_ver_sts_cd]" ).append("\n"); 

	}
}
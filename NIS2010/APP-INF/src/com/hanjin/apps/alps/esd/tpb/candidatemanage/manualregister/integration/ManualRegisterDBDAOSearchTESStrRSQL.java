/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchTESStrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchTESStrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTESStr
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchTESStrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_src_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchTESStrRSQL").append("\n"); 
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
		query.append("SELECT TML_INV_TP_CD TES" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_n3pty_src_no} != '')" ).append("\n"); 
		query.append("AND INV_NO = @[s_n3pty_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_src_vndr_seq} != '')" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[s_src_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.03.09 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 배치 테이블에 이미 invoice가 포함되었는지 여부를 체크
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration ").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL").append("\n"); 
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
		query.append("SELECT 'Y' PROG_FLG" ).append("\n"); 
		query.append("  FROM EAS_AUTO_AUD_BAT" ).append("\n"); 
		query.append(" WHERE SUB_SYS_CD = 'TRS'" ).append("\n"); 
		query.append("   AND INV_NO        = @[inv_no]" ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ  = @[inv_vndr_seq]" ).append("\n"); 
		query.append("   AND TRSP_SO_TP_CD = @[trsp_so_tp_cd]" ).append("\n"); 
		query.append("   AND BAT_PROG_STS_CD = 'P'" ).append("\n"); 

	}
}
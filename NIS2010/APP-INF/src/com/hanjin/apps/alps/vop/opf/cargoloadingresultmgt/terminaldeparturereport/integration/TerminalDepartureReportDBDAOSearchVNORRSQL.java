/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchVNORRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchVNORRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNOR 정보를 조회한다.
	  * 
	  * History
	  * 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchVNORRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchVNORRSQL").append("\n"); 
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
		query.append("SELECT	VSL_CD" ).append("\n"); 
		query.append("		,VNOR_SEQ" ).append("\n"); 
		query.append("		,TO_CHAR(VNOR_OFFH_FM_DT, 'yyyy.mm.dd.hh24:mi') AS VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("		,TO_CHAR(VNOR_OFFH_TO_DT, 'yyyy.mm.dd.hh24:mi') AS VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("		,CR_CHK_FLG" ).append("\n"); 
		query.append("		,SKD_VOY_NO" ).append("\n"); 
		query.append("		,SKD_DIR_CD" ).append("\n"); 
		query.append("		,VNOR_STUP_STS_CD" ).append("\n"); 
		query.append("		,VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("		,VNOR_OFFH_TP_CD" ).append("\n"); 
		query.append("		,VNOR_VSL_STS_CD" ).append("\n"); 
		query.append("		,VNOR_FM_PORT_CD" ).append("\n"); 
		query.append("		,VNOR_TO_PORT_CD" ).append("\n"); 
		query.append("		,VNOR_RMK" ).append("\n"); 
		query.append("		,EML_SND_NO" ).append("\n"); 
		query.append("FROM OPF_VNOR" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND VNOR_SEQ = @[vnor_seq]" ).append("\n"); 

	}
}
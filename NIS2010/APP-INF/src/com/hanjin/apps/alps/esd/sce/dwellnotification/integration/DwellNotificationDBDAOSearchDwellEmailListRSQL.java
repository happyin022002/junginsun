/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwellEmailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwellEmailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dwell Emailing list를 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwellEmailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwellEmailListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SUBSC_EML" ).append("\n"); 
		query.append(", EML_FM_SRC_NM" ).append("\n"); 
		query.append(", COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960', B.EML_PROC_STS_CD) EML_STS" ).append("\n"); 
		query.append("--, TO_CHAR(A.CRE_DT,'YYYY-MM-DD HH24:MI:SS') EML_SND_DT" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', A.CRE_DT, 'USNYC'), 'YYYY-MM-DD HH24:MI:SS') EML_SND_DT" ).append("\n"); 
		query.append("FROM SCE_DWLL_NTFC_EML_SND_RSLT A" ).append("\n"); 
		query.append(", COM_EML_SND_INFO B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EML_SND_NO = B.EML_SND_NO" ).append("\n"); 
		query.append("#if( ${eml_addr} != '' )" ).append("\n"); 
		query.append("AND A.SUBSC_EML LIKE '%'||@[eml_addr]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${eml_snd_dt} != '' )" ).append("\n"); 
		query.append("AND A.EML_SND_DT = TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC', TO_DATE(@[eml_snd_dt] ||'0300', 'YYYYMMDDHH24MI'), 'KRPUS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${cust_cd} != '' )" ).append("\n"); 
		query.append("and A.DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("and A.DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${cntr_no} != '' )" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SUBSC_EML" ).append("\n"); 
		query.append(", EML_FM_SRC_NM" ).append("\n"); 
		query.append(", B.EML_PROC_STS_CD" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 

	}
}
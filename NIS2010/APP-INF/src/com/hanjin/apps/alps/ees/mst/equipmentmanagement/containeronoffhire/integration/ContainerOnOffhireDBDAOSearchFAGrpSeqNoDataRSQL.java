/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchFAGrpSeqNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchFAGrpSeqNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFAGrpSeqNoData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchFAGrpSeqNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchFAGrpSeqNoDataRSQL").append("\n"); 
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
		query.append("    SUBSTR(@[fa_if_grp_seq], 1, 2)||'-'||TO_CHAR(SYSDATE, 'YYYYMMDD')|| '-' ||" ).append("\n"); 
		query.append("    DECODE((SELECT LPAD(MAX(TO_NUMBER(SUBSTR(FA_IF_GRP_SEQ_NO, 13, 4)+1)),4,'0')" ).append("\n"); 
		query.append("            FROM MST_CONTAINER" ).append("\n"); 
		query.append("            WHERE FA_IF_GRP_SEQ_NO LIKE " ).append("\n"); 
		query.append("            SUBSTR(@[fa_if_grp_seq], 1, 2)||'-'||TO_CHAR(SYSDATE, 'YYYYMMDD')||'%'" ).append("\n"); 
		query.append("           ), NULL,'0001', " ).append("\n"); 
		query.append("           (SELECT LPAD(MAX(TO_NUMBER(SUBSTR(FA_IF_GRP_SEQ_NO, 13, 4)+1)),4,'0')" ).append("\n"); 
		query.append("            FROM MST_CONTAINER" ).append("\n"); 
		query.append("            WHERE FA_IF_GRP_SEQ_NO LIKE " ).append("\n"); 
		query.append("            SUBSTR(@[fa_if_grp_seq], 1, 2)||'-'||TO_CHAR(SYSDATE, 'YYYYMMDD')||'%'" ).append("\n"); 
		query.append("           )) GRP_SEQ_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
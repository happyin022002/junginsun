/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSStatusHistoryLsiDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.27 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae-Shung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchCHSStatusHistoryLsiDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기 
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSStatusHistoryLsiDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSStatusHistoryLsiDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ index_desc(a xpkCGM_EQ_sts_his) */" ).append("\n"); 
		query.append("A.STS_EVNT_YD_CD" ).append("\n"); 
		query.append(",A.STS_EVNT_LOC_CD" ).append("\n"); 
		query.append(",A.STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(",to_char(A.STS_EVNT_DT,'yyyy-mm-dd HH24:MI:SS') STS_EVNT_DT" ).append("\n"); 
		query.append(",A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",A.AGMT_VER_NO" ).append("\n"); 
		query.append(",A.EQ_ASET_STS_CD" ).append("\n"); 
		query.append("FROM  CGM_EQ_STS_HIS A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#if ( ${eq_aset_sts_cd} != '' )" ).append("\n"); 
		query.append("AND A.EQ_ASET_STS_CD ='LSI'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
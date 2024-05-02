/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOaddCHSLostHistoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.19 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOaddCHSLostHistoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 히스토리 관리
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOaddCHSLostHistoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOaddCHSLostHistoryDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_EQ_STS_HIS" ).append("\n"); 
		query.append("( EQ_NO" ).append("\n"); 
		query.append(",EQ_STS_SEQ" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",AGMT_VER_NO" ).append("\n"); 
		query.append(",EQ_ASET_STS_CD" ).append("\n"); 
		query.append(",STS_EVNT_YD_CD" ).append("\n"); 
		query.append(",STS_EVNT_LOC_CD" ).append("\n"); 
		query.append(",STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(",STS_EVNT_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("@[eq_no]" ).append("\n"); 
		query.append(",(select max(EQ_STS_SEQ)+1 from CGM_EQ_STS_HIS)" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",AGMT_VER_NO" ).append("\n"); 
		query.append(",'LST'" ).append("\n"); 
		query.append(",@[l_evnt_yd_cd]" ).append("\n"); 
		query.append(",SUBSTR(@[l_evnt_yd_cd],0,5)" ).append("\n"); 
		query.append(",@[ofc_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[l_evnt_dt] ,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("from CGM_EQUIPMENT" ).append("\n"); 
		query.append("where eq_no= @[eq_no]" ).append("\n"); 

	}
}
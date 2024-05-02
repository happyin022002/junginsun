/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOaddMGSEqSpecDataCSQL.java
*@FileTitle : Chassis Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.09 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eui-su Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOaddMGSEqSpecDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOaddMGSEqSpecDataCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_vltg_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_fuel_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO CGM_EQ_SPEC" ).append("\n"); 
		query.append("(EQ_SPEC_NO, EQ_KND_CD, EQ_TPSZ_CD, VNDR_SEQ, MGST_VLTG_CAPA," ).append("\n"); 
		query.append("MGST_FUEL_CAPA, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[eq_spec_no], @[eq_knd_cd], @[eq_tpsz_cd], @[vndr_seq], @[mgst_vltg_capa]," ).append("\n"); 
		query.append("@[mgst_fuel_capa], @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOaddMGSEqSpecDataCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
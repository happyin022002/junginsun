/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyOwnCntrMastersUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.19 이호선
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

public class ContainerOnOffhireDBDAOModifyOwnCntrMastersUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약번호,제작일자,행거랙,Plastic Floor 수정시에만
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyOwnCntrMastersUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plst_flr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyOwnCntrMastersUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER A " ).append("\n"); 
		query.append("SET ONH_DT		     =  DECODE(HJS_CRE_FLG,'Y',TO_DATE(@[mft_dt],'YYYY-MM-DD'),ONH_DT)" ).append("\n"); 
		query.append(" , MFTR_VNDR_SEQ     = @[mft_vndr_seq]  			-- MST_CNTR_LOT테이블의 mft_vndr_seq와 동일" ).append("\n"); 
		query.append(" , MFT_DT		     = TO_DATE(@[mft_dt],'YYYY-MM-DD')          " ).append("\n"); 
		query.append(" , CNTR_HNGR_RCK_CD	 = DECODE(CNTR_HNGR_RCK_CD,'R',CNTR_HNGR_RCK_CD,@[cntr_hngr_rck_cd])" ).append("\n"); 
		query.append(" , PLST_FLR_FLG		 = @[plst_flr_flg]" ).append("\n"); 
		query.append(" , RF_TP_CD          = @[unit_type] " ).append("\n"); 
		query.append(" , UPD_USR_ID		 = @[upd_usr_id]" ).append("\n"); 
		query.append(" , UPD_DT		     = SYSDATE          " ).append("\n"); 
		query.append("WHERE CNTR_NO BETWEEN @[fm_no]||'0' AND @[to_no]||'9'" ).append("\n"); 
		query.append("AND    LENGTH(CNTR_NO) = 11" ).append("\n"); 

	}
}
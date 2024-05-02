/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetConvInToUVDFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.24 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetConvInToUVDFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetConvInToUVDFlg
	  * 
	  * 
	  * -- SAMSUNG_GRP_CD_CNT : Conversion 대상이고 [IC to VD] (현재는 삼성만)
	  * -- POD_VVD_NOT_ASSIGNED_CNT : POD 에 VVD가 Assign되지 않았고, (VVD 있으면 추후 VD가 들어올 것이므로)
	  * -- UVD_SND_CNT : 기존 VD 전송 내역 없음.
	  * </pre>
	  */
	public Edi315SendDBDAOGetConvInToUVDFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetConvInToUVDFlgRSQL").append("\n"); 
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
		query.append("case when POD_VVD_NOT_ASSIGNED_CNT > 0" ).append("\n"); 
		query.append("and  UVD_SND_CNT = 0" ).append("\n"); 
		query.append("then 'Y'" ).append("\n"); 
		query.append("else 'N'" ).append("\n"); 
		query.append("end v_conv_ic_to_vd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT count(*) POD_VVD_NOT_ASSIGNED_CNT" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("and COP_NO = @[cop_no]" ).append("\n"); 
		query.append("and ACT_CD like 'FU_MUD'" ).append("\n"); 
		query.append("and VSL_CD is null" ).append("\n"); 
		query.append(")DTL_VVD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT count(*) UVD_SND_CNT" ).append("\n"); 
		query.append("FROM SCE_EDI_SND_RSLT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EDI_GRP_CD = @[edi_grp_cd]" ).append("\n"); 
		query.append("AND EDI_STS_CD = 'UVD'" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(")EDI_SND_RSLT" ).append("\n"); 

	}
}
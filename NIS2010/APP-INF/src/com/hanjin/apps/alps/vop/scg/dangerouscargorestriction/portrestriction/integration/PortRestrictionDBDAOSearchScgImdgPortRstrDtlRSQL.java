/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOSearchScgImdgPortRstrDtlRSQL.java
*@FileTitle : Excepted Quantities (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOSearchScgImdgPortRstrDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOSearchScgImdgPortRstrDtlRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_prohi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("A.PORT_CD              ," ).append("\n"); 
		query.append("A.IMDG_PORT_RSTR_SEQ   ," ).append("\n"); 
		query.append("A.PORT_PROHI_TP_CD     ," ).append("\n"); 
		query.append("A.IMDG_CMPTN_AUTH_CD   ," ).append("\n"); 
		query.append("A.TON_OVR_VOL_QTY      ," ).append("\n"); 
		query.append("A.ND_TM_HRS            ," ).append("\n"); 
		query.append("A.TML_MAX_QTY          ," ).append("\n"); 
		query.append("A.OBRD_MAX_QTY         ," ).append("\n"); 
		query.append("A.ONE_TM_HNDL_MAX_QTY  ," ).append("\n"); 
		query.append("A.DYS_STO_FLG          ," ).append("\n"); 
		query.append("A.STO_DYS              ," ).append("\n"); 
		query.append("A.PROHI_DESC           ," ).append("\n"); 
		query.append("A.TXT_DESC             ," ).append("\n"); 
		query.append("A.CRE_USR_ID           ," ).append("\n"); 
		query.append("A.CRE_DT               ," ).append("\n"); 
		query.append("A.UPD_USR_ID           ," ).append("\n"); 
		query.append("A.UPD_DT               ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD  = 'L' THEN STO_DYS END  LOAD_STO_DYS ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD  = 'D' THEN STO_DYS END  DIS_STO_DYS ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD  = 'T' THEN STO_DYS END  TS_STO_DYS  ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD  = 'L' THEN DYS_STO_FLG END  LOAD_DYS_STO_FLG ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD  = 'D' THEN DYS_STO_FLG END  DIS_DYS_STO_FLG ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD  = 'T' THEN DYS_STO_FLG END  TS_DYS_STO_FLG ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' THEN TXT_DESC END  LOAD_TXT_DESC ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' THEN TXT_DESC END  DIS_TXT_DESC," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' THEN TXT_DESC END TS_TXT_DESC  ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' THEN TXT_DESC END  PASS_TXT_DESC ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' THEN TML_MAX_QTY END LOAD_TML_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' THEN TML_MAX_QTY END DIS_TML_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' THEN TML_MAX_QTY END TS_TML_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' THEN TML_MAX_QTY END PASS_TML_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' THEN OBRD_MAX_QTY END  LOAD_OBRD_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' THEN OBRD_MAX_QTY END  DIS_OBRD_MAX_QTY," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' THEN OBRD_MAX_QTY END  TS_OBRD_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' THEN OBRD_MAX_QTY END  PASS_OBRD_MAX_QTY," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' THEN ONE_TM_HNDL_MAX_QTY END   LOAD_ONE_TM_HNDL_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' THEN ONE_TM_HNDL_MAX_QTY END   DIS_ONE_TM_HNDL_MAX_QTY," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' THEN ONE_TM_HNDL_MAX_QTY END   TS_ONE_TM_HNDL_MAX_QTY ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' THEN ONE_TM_HNDL_MAX_QTY END   PASS_ONE_TM_HNDL_MAX_QTY ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' AND B.PROHI_LOD_FLG='N' THEN TON_OVR_VOL_QTY ELSE 0 END  LOAD_TON_OVR_VOL_QTY      ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' AND B.PROHI_DCHG_FLG='N' THEN TON_OVR_VOL_QTY ELSE 0  END  DIS_TON_OVR_VOL_QTY      ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' AND B.PROHI_TS_FLG='N' THEN TON_OVR_VOL_QTY ELSE 0  END  TS_TON_OVR_VOL_QTY      ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' AND B.PROHI_PASS_FLG='N' THEN TON_OVR_VOL_QTY  ELSE 0 END  PASS_TON_OVR_VOL_QTY      ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' AND B.PROHI_LOD_FLG='N' THEN ND_TM_HRS  ELSE 0 END  LOAD_ND_TM_HRS      ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' AND B.PROHI_DCHG_FLG='N' THEN ND_TM_HRS  ELSE 0 END  DIS_ND_TM_HRS      ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' AND B.PROHI_TS_FLG='N'    THEN ND_TM_HRS  ELSE 0 END  TS_ND_TM_HRS      ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' AND B.PROHI_PASS_FLG='N'  THEN ND_TM_HRS  ELSE 0 END  PASS_ND_TM_HRS    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'L' AND B.PROHI_LOD_FLG='N' THEN IMDG_CMPTN_AUTH_CD END  LOAD_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'D' AND B.PROHI_DCHG_FLG='N' THEN IMDG_CMPTN_AUTH_CD END  DIS_IMDG_CMPTN_AUTH_CD ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'T' AND B.PROHI_TS_FLG='N' THEN IMDG_CMPTN_AUTH_CD END  TS_IMDG_CMPTN_AUTH_CD  ," ).append("\n"); 
		query.append("CASE WHEN A.PORT_PROHI_TP_CD = 'P' AND B.PROHI_PASS_FLG='N' THEN IMDG_CMPTN_AUTH_CD END  PASS_IMDG_CMPTN_AUTH_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    SCG_IMDG_PORT_RSTR_DTL A, SCG_IMDG_PORT_RSTR B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("AND   A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("AND   A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND   A.IMDG_PORT_RSTR_SEQ = @[imdg_port_rstr_seq]" ).append("\n"); 
		query.append("#if (${port_prohi_tp_cd} != ''  )" ).append("\n"); 
		query.append("AND   A.PORT_PROHI_TP_CD   = @[port_prohi_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY (CASE WHEN A.PORT_PROHI_TP_CD='L' THEN 1" ).append("\n"); 
		query.append("WHEN A.PORT_PROHI_TP_CD='D' THEN 2" ).append("\n"); 
		query.append("WHEN A.PORT_PROHI_TP_CD='T' THEN 3" ).append("\n"); 
		query.append("WHEN A.PORT_PROHI_TP_CD='P' THEN 4 END)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOSearchScgImdgPortRstrDtlRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
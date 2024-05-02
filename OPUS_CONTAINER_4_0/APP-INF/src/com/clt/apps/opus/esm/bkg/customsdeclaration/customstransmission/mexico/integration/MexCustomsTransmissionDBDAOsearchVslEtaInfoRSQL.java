/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchVslEtaInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchVslEtaInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, outVO : MxEtaInfoVO (searchVslInfoVsl과 함께 사용하는 VO, 생성은 searchVslInfoVsl 에서 하는 것으로 정의한다.)
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchVslEtaInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchVslEtaInfoRSQL").append("\n"); 
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
		query.append("SELECT 'O' BRAC" ).append("\n"); 
		query.append(",NVL(A.VSL_CD, '')||NVL(A.SKD_VOY_NO, '')||NVL(A.SKD_DIR_CD, '') VVD" ).append("\n"); 
		query.append(",NVL(D.CALL_SGN_NO, '') VSL_CALLSIGN" ).append("\n"); 
		query.append(",NVL(D.LLOYD_NO, '') VSL_LLOYDCODE" ).append("\n"); 
		query.append(",NVL(D.VSL_ENG_NM, '') VSL_FULLNAME" ).append("\n"); 
		query.append(",NVL(D.VSL_RGST_CNT_CD, '') VSL_FLAG" ).append("\n"); 
		query.append(",NVL(A.SLAN_CD, '') LANE_CD" ).append("\n"); 
		query.append(",NVL(A.SHP_CALL_NO, '') VVD_REF_NO" ).append("\n"); 
		query.append(",NVL(DECODE(SUBSTR(@[pol_cd],1,2),'MX', @[pol_cd], @[pod_cd]),'') PORT" ).append("\n"); 
		query.append(",NVL((SELECT LOC_NM" ).append("\n"); 
		query.append("      FROM MDM_LOCATION" ).append("\n"); 
		query.append("     WHERE LOC_CD = NVL(@[pod_cd],@[pol_cd])), '') PORTNAME" ).append("\n"); 
		query.append(",NVL(TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MI'), '') ETA" ).append("\n"); 
		query.append(",NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MI'), '') ETD" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', DECODE(@[pod_cd], NULL, C.VPS_PORT_CD, ' ') ) NEXTPORT" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, '', DECODE(@[pod_cd], NULL, TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'), ' ') ) NEXTPORT_ETA" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, NVL(B.VPS_PORT_CD, ' '), DECODE(@[pod_cd], NULL, ' ', NVL(B.VPS_PORT_CD, ' ') ) ) PREVPORT" ).append("\n"); 
		query.append(", DECODE(@[pol_cd], NULL, NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),' '), DECODE(@[pod_cd], NULL, ' ',  NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),' ') ) )PREVPORT_ETD" ).append("\n"); 
		query.append(", DECODE(" ).append("\n"); 
		query.append("	SUBSTR(@[pol_cd], 1, 2), " ).append("\n"); 
		query.append("	'MX', DECODE(" ).append("\n"); 
		query.append("			@[pod_cd], " ).append("\n"); 
		query.append("			null, DECODE(SUBSTR(C.VPS_PORT_CD, 1, 2), 'MX', 'TO', 'O')," ).append("\n"); 
		query.append("			''" ).append("\n"); 
		query.append("		  )," ).append("\n"); 
		query.append("	DECODE(@[pol_cd]," ).append("\n"); 
		query.append("		null, DECODE(SUBSTR(@[pod_cd], 1, 2),'MX','TC','')," ).append("\n"); 
		query.append("		'I'" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  ) IO_IND" ).append("\n"); 
		query.append(", 'USA' COMP_ID" ).append("\n"); 
		query.append(", NVL(D.CRR_CD,' ') MRN" ).append("\n"); 
		query.append(", NVL(E.CRR_NM,' ') MRN_NAME" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B, VSK_VSL_PORT_SKD C, MDM_VSL_CNTR D, MDM_CARRIER E" ).append("\n"); 
		query.append("WHERE A.VSL_CD                   =  SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO                 =  SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD                 =  SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND A.CLPT_IND_SEQ				 =  1" ).append("\n"); 
		query.append("AND NVL(A.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD                =  NVL(@[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("AND B.VSL_CD(+)                  =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO(+)           	 =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD(+)              =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.CLPT_IND_SEQ(+)			 =  1" ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD(+), ' ') <> 'S'" ).append("\n"); 
		query.append("AND B.CLPT_SEQ(+)                =  A.CLPT_SEQ - 1" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("AND C.CLPT_SEQ(+)            	 =  A.CLPT_SEQ +1" ).append("\n"); 
		query.append("AND C.VSL_CD(+)                  =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO(+)              =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD(+)              =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.CLPT_IND_SEQ(+)			 =  1" ).append("\n"); 
		query.append("AND NVL(C.SKD_CNG_STS_CD(+), ' ') <> 'S'" ).append("\n"); 
		query.append("AND A.VSL_CD                     =  D.VSL_CD" ).append("\n"); 
		query.append("AND D.CRR_CD					 =  E.CRR_CD" ).append("\n"); 

	}
}
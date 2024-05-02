/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeAutoIMFMODFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.30 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeAutoIMFMODFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Empty BL FlatFile
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeAutoIMFMODFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeAutoIMFMODFlatFileRSQL").append("\n");
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
		query.append("SELECT	S1.FF FLAT_DATA," ).append("\n");
		query.append("S1.BL_NO BL_NO," ).append("\n");
		query.append("S1.TS_POL_CD POL_CD" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT 'MSG_CD:'	   ||'5LI'						            ||'~'||	/*	Message Code        */" ).append("\n");
		query.append("'MSG_NO:'	   ||@[sub_no]					            ||'~'||	/*	MSG No., Submit No.	*/" ).append("\n");
		query.append("'SEND_DT:'	   ||TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')	||'~'|| /*	전송 Date & Time    */" ).append("\n");
		query.append("'PORT_CD:'	   ||TO_CHAR(KV.LOCL_CSTMS_CD,'FM000')	   	||'~'||	/*	Customs Office		*/" ).append("\n");
		query.append("'DEPT_CD:'	   ||'10'						            ||'~'||	/*	Customs Department	*/" ).append("\n");
		query.append("'SENDER:'	   ||SUBSTR(@[usr_nm],1,35)			        ||'~'||	/*	정정 신청자 성명	*/" ).append("\n");
		query.append("'CORR_CD:'      ||'B'						            ||'~'||	/*	Correction Code     *//* INBOUND 자동 정정신고는 BL수정 후 전송 */" ).append("\n");
		query.append("'CORR_RS:'	   ||'Empty B/L Type 정정'				    ||'~'||	/*	Correction Reason	*/" ).append("\n");
		query.append("'MSN_NO:'       ||KT.MST_BL_SEQ_NO			            ||'~'||	/*	M-B/L Sequence No.  */" ).append("\n");
		query.append("'BL_NO:'        ||KT.CSTMS_BL_NO				            ||'~'||	/*	B/L No              */" ).append("\n");
		query.append("'BL_TP:'        ||DECODE(KT.BKG_CGO_TP_CD, 'R', DECODE(KT.KR_CSTMS_BL_TP_CD, 'S', 'E', 'C', 'E', KT.KR_CSTMS_BL_TP_CD), KT.KR_CSTMS_BL_TP_CD) ||'~'||	/*	B/L Type            */" ).append("\n");
		query.append("'FW_CD:'        ||DECODE(KT.KR_CSTMS_BL_TP_CD,'C',NVL(KT.CSTMS_FWRD_ID,' '),' ')	||'~'||	/*	Forward Code        */" ).append("\n");
		query.append("'CGO_TP:'       ||'T'						            ||'~'||	/*	Trans. Indicator   INBOUND 자동정정신고의 경우 무조건 T/S Export */" ).append("\n");
		query.append("'BKG_POL:'      ||LOCATION_POL.UN_LOC_CD			    	||'~'||	/*	Booking POL         */" ).append("\n");
		query.append("'BKG_POD:'      ||LOCATION_POD.UN_LOC_CD		       		||'~'||	/*	Booking POD         */" ).append("\n");
		query.append("'BOND_AREA_CODE:'||KT.BD_AREA_CD			        		||'~'||	/*	장치장코드          */" ).append("\n");
		query.append("'DISC_LOC:'	   ||KT.KR_CSTMS_WH_TP_CD||KT.KR_WH_CD		||'~'||	/*	하선 장소			*/" ).append("\n");
		query.append("'PKG:'          ||KT.PCK_QTY				        		||'~'||	/*	Package Count       */" ).append("\n");
		query.append("'PKG_CD:'       ||KT.PCK_QTY				            	||'~'||	/*	Package Code        */" ).append("\n");
		query.append("'CGO_DESC1:'    ||BKG_SPCLCHAR_CONV_FNC(KT.CGO_DESC1,'Y')||'~'||	/*	Cargo Description1  */" ).append("\n");
		query.append("'CGO_DESC2:'    ||BKG_SPCLCHAR_CONV_FNC(KT.CGO_DESC2,'Y')||'~'||	/*	Cargo Description2  */" ).append("\n");
		query.append("'IMO_CLASS1:'   ||KT.IMDG_CLSS_CD			            ||'~'||	/*	IMO Class 1         */" ).append("\n");
		query.append("'IMO_CLASS2:'   ||KT.N2ND_IMDG_CLSS_CD		        	||'~'||	/*	IMO Class 2         */" ).append("\n");
		query.append("'IMO_CLASS3:'   ||KT.N3RD_IMDG_CLSS_CD			        ||'~'||	/*	IMO Class 3         */" ).append("\n");
		query.append("'WGT:'          ||KT.CNTR_TTL_WGT		               	||'~'||	/*	Weight              */" ).append("\n");
		query.append("'MEA:'          ||KT.MEAS_QTY			               	||'~'||	/*	Measure             */" ).append("\n");
		query.append("'HBL_CNT:'	||''						                ||'~'||	/*	H-B/L Count (?)		*/" ).append("\n");
		query.append("'SHPR1:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_NM,1,35),'Y')		||'~'||	/*	Shipper Name1		*/" ).append("\n");
		query.append("'SHPR2:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_ADDR,1,35),'Y')	||'~'||	/*	Shipper Addr 1		*/" ).append("\n");
		query.append("'SHPR3:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_ADDR,36,35),'Y')	||'~'||	/*	Shipper Addr 2		*/" ).append("\n");
		query.append("'SHPR4:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(S_CUST.CUST_ADDR,72,35),'Y')	||'~'||	/*	Shipper Addr 3		*/" ).append("\n");
		query.append("'CNEE1:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_NM,1,35),'Y')		||'~'||	/*	CNEE Name 1			*/" ).append("\n");
		query.append("'CNEE2:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_ADDR,1,35),'Y')	||'~'||	/*	CNEE Addr 1			*/" ).append("\n");
		query.append("'CNEE3:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_ADDR,36,35),'Y')	||'~'||	/*	CNEE Addr 2			*/" ).append("\n");
		query.append("'CNEE4:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(C_CUST.CUST_ADDR,72,35),'Y')	||'~'||	/*	CNEE Addr 3			*/" ).append("\n");
		query.append("'CBIZNO:'||KT.BIZ_RGST_NO					            ||'~'||	/*	CNEE 사업자등록번호	*/" ).append("\n");
		query.append("'NTFY1:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_NM,1,35),'Y')		||'~'||	/*	NTFY Name 1			*/" ).append("\n");
		query.append("'NTFY2:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_ADDR,1,35),'Y')	||'~'||	/*	NTFY Addr1			*/" ).append("\n");
		query.append("'NTFY3:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_ADDR,36,35),'Y')	||'~'||	/*	NTFY Addr2			*/" ).append("\n");
		query.append("'NTFY4:'	||BKG_SPCLCHAR_CONV_FNC(SUBSTR(N_CUST.CUST_ADDR,72,35),'Y')	||'~'||	/*	NTFY Addr3			*/" ).append("\n");
		query.append("'NBIZNO:'||KT.BIZ_RGST_NO							/*	NTFY 사업자등록번호	*/" ).append("\n");
		query.append("FF," ).append("\n");
		query.append("KT.BL_NO BL_NO," ).append("\n");
		query.append("KT.TS_POL_CD" ).append("\n");
		query.append("FROM	BKG_CSTMS_ADV_KR_BL KT," ).append("\n");
		query.append("BKG_CSTMS_ADV_KR_VVD_SMRY KV," ).append("\n");
		query.append("MDM_LOCATION LOCATION_POL," ).append("\n");
		query.append("MDM_LOCATION LOCATION_POD," ).append("\n");
		query.append("BKG_CSTMS_ADV_KR_CUST S_CUST," ).append("\n");
		query.append("BKG_CSTMS_ADV_KR_CUST C_CUST," ).append("\n");
		query.append("BKG_CSTMS_ADV_KR_CUST N_CUST" ).append("\n");
		query.append("WHERE	KT.VSL_CD		= KV.VSL_CD" ).append("\n");
		query.append("AND	KT.SKD_VOY_NO	    = KV.SKD_VOY_NO" ).append("\n");
		query.append("AND	KT.SKD_DIR_CD		= KV.SKD_DIR_CD" ).append("\n");
		query.append("AND	KT.DMST_PORT_CD		= KV.PORT_CD" ).append("\n");
		query.append("AND	DECODE(KT.CSTMS_DECL_TP_CD,'I','I','T','I')	= KV.IO_BND_CD" ).append("\n");
		query.append("AND	NVL(KT.PORT_TML_CD,' ')		= NVL(KV.PORT_TML_CD,' ')" ).append("\n");
		query.append("AND	KT.POL_CD	= LOCATION_POL.LOC_CD" ).append("\n");
		query.append("AND	KT.POD_CD	= LOCATION_POD.LOC_CD" ).append("\n");
		query.append("AND	KT.BKG_NO	= S_CUST.BKG_NO" ).append("\n");
		query.append("AND	KT.BKG_NO	= C_CUST.BKG_NO" ).append("\n");
		query.append("AND	KT.BKG_NO	= N_CUST.BKG_NO" ).append("\n");
		query.append("AND	KT.CSTMS_BL_NO	= @[cstms_bl_no]" ).append("\n");
		query.append("AND	KT.TRNS_SEQ	= @[trns_seq]" ).append("\n");
		query.append("AND	KT.DMST_PORT_CD	= @[dmst_port_cd]" ).append("\n");
		query.append("AND	KT.BKG_NO	= @[bkg_no]" ).append("\n");
		query.append("AND	KT.CSTMS_DECL_TP_CD	= @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND	S_CUST.BKG_CUST_TP_CD = 'S'" ).append("\n");
		query.append("AND	C_CUST.BKG_CUST_TP_CD = 'C'" ).append("\n");
		query.append("AND	N_CUST.BKG_CUST_TP_CD = 'N'" ).append("\n");
		query.append("ORDER BY KV.VVD_SEQ DESC) S1" ).append("\n");
		query.append("WHERE ROWNUM = 1" ).append("\n");

	}
}
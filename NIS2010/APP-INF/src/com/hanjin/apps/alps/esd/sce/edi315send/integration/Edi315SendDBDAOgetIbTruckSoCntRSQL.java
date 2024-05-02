/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Edi315SendDBDAOgetIbTruckSoCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.20 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOgetIbTruckSoCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHM-201327177 Nike Canada EDI event 관련 로직 보완 요청 (OAN, VAD 관련)
	  * VAD for Local move by truck => AOL 이 자동전송되도록 설정 . 이부분은 ALPS쪽 hard coding을 해주십시요. Truck move 인지 Rail move 인지 edi.smlines.com 설정이 불가 하기 때문입니다.
	  * VAD는 ACTUAL TIME OF VESSEL ARRIVAL AT POD PORT 로서 Truck이나 Rail move가 존재하지 않는데 어떤 의미로 요청한 것인지 다시 설명 부탁 드립니다.
	  * Container 가 POD 도착후 truck 으로 이송되는 경우에만 해당container 에 대한  VAD 발생시  AOL 도 자동 전송 여부 체크
	  * </pre>
	  */
	public Edi315SendDBDAOgetIbTruckSoCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOgetIbTruckSoCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND COP_NO = @[cop_no]" ).append("\n"); 
		query.append("   AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("   AND TRSP_MOD_CD IN ('TD','TR')" ).append("\n"); 
		query.append("   AND CTRL_OFC_CD <> 'CLTCO'" ).append("\n"); 

	}
}